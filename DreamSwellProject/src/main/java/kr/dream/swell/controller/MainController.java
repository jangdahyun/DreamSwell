package kr.dream.swell.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.dream.swell.service.DreamSwellBoardService;
import kr.dream.swell.service.Fileservice;
import kr.dream.swell.vo.CommonVO;
import kr.dream.swell.vo.DreamSwellBoardVO;
import kr.dream.swell.vo.DreamSwellCategoryVO;
import kr.dream.swell.vo.DreamSwellFileBoardVO;
import kr.dream.swell.vo.DreamUserVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Configuration
@Slf4j
public class MainController {
	
	@Autowired
	private DreamSwellBoardService boardService;
	
	@Autowired
	private Fileservice fileservice;
	
	@GetMapping("/")
	public String mainPage(@ModelAttribute(value = "cv") CommonVO cv,HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
		}
		DreamSwellFileBoardVO boardVO = new DreamSwellFileBoardVO();
		log.debug("안녕{}",cv);
		List<String> categoryList= boardService.findCategoryList();
		List<DreamSwellBoardVO> pv =boardService.selectScrollBoard(boardService.findLastItemIdx()+1,cv.getS(), cv.getCategoryNum(), cv.getSearch(), cv.getEndDate());
		log.debug("안녕{}",pv);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("sc", pv);
		model.addAttribute("cv", cv);
		model.addAttribute("hh", boardVO);
		
		return "index";
	}
	
	@GetMapping("/view/{idx}")
	public String  donationPage(@PathVariable(value = "idx") Long idx, Model model, HttpServletRequest request, HttpServletResponse response) {
		DreamSwellBoardVO dreamSwellBoardVO = boardService.selectByIdx(idx);
		DreamUserVO userVO = (DreamUserVO) request.getSession().getAttribute("user");
		
		//삭제된 게시판에 들어가면 오류 처리
		if(dreamSwellBoardVO == null) {
			return "redirect:?error=notFound";
		}
		if (request.getSession().getAttribute("user")!=null) {
			
			model.addAttribute("currentUser", userVO.getIdx());
		}
		model.addAttribute("board",dreamSwellBoardVO);
		
		
		return "page";
	}
	
	@GetMapping("/boardupload")
	public String boardUpload(@ModelAttribute(value = "category")DreamSwellCategoryVO categoryVO ) {
		return "boardupload";
	}
	
	
	//MultipartHttpServletRequest 파일을 받을 수 있는.
	@Transactional //한꺼번에 저장하기 위해 하나가 에러가되면 모든게 막히게
	@PostMapping("/boardUploadOk")
	public String boardUploadOk(HttpSession session, @ModelAttribute(value = "boardVO") DreamSwellBoardVO boardVO, MultipartHttpServletRequest request) {
		// 1.board 저장
		DreamUserVO memberVO = (DreamUserVO)session.getAttribute("user");
		log.debug("왜 이래{}",memberVO);
		boardVO.setUserRef(memberVO.getIdx());
		
		String uploadPath = request.getServletContext().getRealPath("./upload/");
		
		 File file2 = new File(uploadPath);
	     if (!file2.exists()) {
	        file2.mkdirs();
	     }
	    log.info("서버 실제 경로 : " + uploadPath); // 확인용
	    
	    int count =1;
	    // 여러개 파일 받기
        List<MultipartFile> list = request.getFiles("file"); // form에 있는 name과 일치
        String url = "";
        String filepath = "";
        try {
           if (list != null && list.size() > 0) { // 받은 파일이 존재한다면
              // 반복해서 받는다.
              for (MultipartFile file : list) {
                 // 파일이 없으면 처리하지 않는다.
                 if (file != null && file.getSize() > 0) {
                    // 저장파일의 이름 중복을 피하기 위해 저장파일이름을 유일하게 만들어 준다.
                    String saveFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    // 파일 객체를 만들어 저장해 준다.
                    File saveFile = new File(uploadPath, saveFileName);
                    // 파일 복사
                    FileCopyUtils.copy(file.getBytes(), saveFile);
                    
                    url = file.getOriginalFilename();	// original
                    filepath = saveFileName;			// savefileName
                    
                    DreamSwellFileBoardVO fileBoardVO = new DreamSwellFileBoardVO();
                    fileBoardVO.setUrl(url);
                    fileBoardVO.setFilepath(filepath);
                    boardVO.setThumbnail(filepath);
                    boardService.insert(boardVO);
                    fileBoardVO.setRef(boardVO.getIdx());
                    log.debug("안녕{}",fileBoardVO);
            		log.info("ㅂㅂ{}",boardVO);
                    fileservice.insert(fileBoardVO);
                    log.info("11:{}" , fileBoardVO);
                    log.info("COUNT2:{}" , count++);
                   
                 }
              }
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return "boardupload";
	}

	@PostMapping("/getScrollItem")
	@ResponseBody
	public List<DreamSwellBoardVO> getScrollItem(@RequestBody Map<String, String> map){
		log.info("getScrollItem : {}", map);
		List<DreamSwellBoardVO> result = boardService.selectScrollBoard((long) Integer.parseInt(map.get("lastItemIdx")), Integer.parseInt(map.get("sizeOfPage")), null, map.get("search"), null);
		return result;
	}

	
	// 딱! 한번만 실행해야한다!
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	
	/**
	 * 초기 어드민들 패스워드 암호화하는 주소
	 * @return
	 */
	//@GetMapping("/dbinit") // 기존에 등록된 비번을 암호화 해서 변경한다. 1번만 실행하고 지워줘라~~~
	public String dbInit() {
		jdbcTemplate.update("update dreamUser set password=? where username=?", passwordEncoder.encode("123456"),"admin");
		jdbcTemplate.update("update dreamUser set password=? where username=?", passwordEncoder.encode("123456"),"master");
		jdbcTemplate.update("update dreamUser set password=? where username=?", passwordEncoder.encode("123456"),"webmaster");
		jdbcTemplate.update("update dreamUser set password=? where username=?", passwordEncoder.encode("123456"),"root");
		jdbcTemplate.update("update dreamUser set password=? where username=?", passwordEncoder.encode("123456"),"dba");
		return "redirect:/";
	}
}
