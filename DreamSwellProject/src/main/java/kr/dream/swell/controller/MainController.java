package kr.dream.swell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;
import kr.dream.swell.service.DreamSwellBoardService;
import kr.dream.swell.vo.CommonVO;
import kr.dream.swell.vo.DreamSwellBoardVO;

@Controller
@Configuration
public class MainController {
	
	@Autowired
	private DreamSwellBoardService boardService;
	
	@GetMapping("/")
	public String mainPage(@ModelAttribute(value = "cv") CommonVO cv,HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
		}
		List<String> categoryList= boardService.findCategoryList();
		List<DreamSwellBoardVO> pv =boardService.selectScrollBoard(boardService.findLastItemIdx()+1,cv.getS(), cv.getCategoryNum(), cv.getSearch());
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("sc", pv);
		model.addAttribute("cv", cv);
		return "index";
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
