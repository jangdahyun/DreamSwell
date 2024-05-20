package kr.dream.swell.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.dream.swell.dao.DreamBoardDAO;
import kr.dream.swell.dao.DreamCategoryDAO;
import kr.dream.swell.dao.DreamFileBoardDAO;
import kr.dream.swell.vo.DreamSwellBoardVO;
import lombok.extern.slf4j.Slf4j;

@Service(value = "dreamSwellBoardService")
@Slf4j
public class DreamSwellBoardServiceImp implements DreamSwellBoardService{

	@Autowired
	private DreamBoardDAO dreamBoardDAO;
	
	@Autowired
	private DreamUserService dreamUserService;
	
	@Autowired
	private DreamCategoryDAO dreamCategoryDAO;
	
	@Autowired
	private DreamFileBoardDAO fileBoardDAO;
	
	@Override
	public ArrayList<DreamSwellBoardVO> selectScrollBoard(Long lastItemIdx, int sizeOfPage, Integer categoryNum, String search, String endDate, String end ) {
		ArrayList<DreamSwellBoardVO> list = null;
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("lastItemIdx", lastItemIdx);
			map.put("sizeOfPage", sizeOfPage);
			map.put("categoryNum", categoryNum);
			map.put("search", search);
			map.put("endDate", LocalDate.now());
			map.put("end", end);
			
			list= dreamBoardDAO.selectScrollList(map);
			log.debug("리스트:{}",list);
			log.debug("리스트2:{}",map);
			for(DreamSwellBoardVO boardVO : list) {
				//유정 정보 
				boardVO.setMember(dreamUserService.selectByIdx(boardVO.getUserRef()));
				
				//카테고리 정보 
				List<String> categoryNames=new ArrayList<>();
				 if (boardVO.getCategory1() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory1()));
		            }
		            if (boardVO.getCategory2() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory2()));
		            }
		            if (boardVO.getCategory3() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory3()));
		            }
		            log.debug("ㅇㅇ{}",categoryNames);
		            log.debug("맵:{}",map);
		            boardVO.setCategoryName1(categoryNames);
		            
		            //파일 정보
		            boardVO.setFileboardVO(fileBoardDAO.selectfileByRef(boardVO.getIdx()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<DreamSwellBoardVO> selectScrollBoardOld(int sizeOfPage, Integer categoryNum, String search,  String endDate) {
		ArrayList<DreamSwellBoardVO> list = null;
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("sizeOfPage", sizeOfPage);
			map.put("categoryNum", categoryNum);
			map.put("search", search);
			map.put("endDate", LocalDate.now());
			
			list= dreamBoardDAO.selectScrollListOld(map);
			log.debug("정다현",list);
			log.debug("정다현2:{}",map);
			for(DreamSwellBoardVO boardVO : list) {
				//유정 정보 
				boardVO.setMember(dreamUserService.selectByIdx(boardVO.getUserRef()));
				
				//카테고리 정보 
				List<String> categoryNames=new ArrayList<>();
				 if (boardVO.getCategory1() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory1()));
		            }
		            if (boardVO.getCategory2() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory2()));
		            }
		            if (boardVO.getCategory3() != null) {
		                categoryNames.add(dreamCategoryDAO.selectCategoryBycategoryNum(boardVO.getCategory3()));
		            }
		            log.debug("ㅇㅇ{}",categoryNames);
		            log.debug("맵:{}",map);
		            boardVO.setCategoryName1(categoryNames);
		            
		            //파일 정보
		            boardVO.setFileboardVO(fileBoardDAO.selectfileByRef(boardVO.getIdx()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Long findLastItemIdx() {
	    Long result = 0L; // Long으로 선언하고 기본값 설정
	    try {
	        result = dreamBoardDAO.findLastItemIdx();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	@Override
	public DreamSwellBoardVO selectByIdx(Long idx) {
		DreamSwellBoardVO boardVO = null;
		try {
			boardVO = dreamBoardDAO.selectByIdx(idx);
			if (boardVO != null) {
				//유저정보
				boardVO.setMember(dreamUserService.selectByIdx(idx));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardVO;
	}

	@Override
	public void insert(DreamSwellBoardVO boardVO) {
		try {
			dreamBoardDAO.insert(boardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Long idx) {
		try {
			dreamBoardDAO.delete(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByUserRef(Long ref) {
		try {
			dreamBoardDAO.deleteByUserRef(ref);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(DreamSwellBoardVO boardVO) {
		try {
			dreamBoardDAO.update(boardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLove(Long idx) {
		try {
			dreamBoardDAO.updateLove(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pupdateComment(Long idx) {
		try {
			dreamBoardDAO.pupdateComment(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mupdateComment(Long idx) {
		try {
			dreamBoardDAO.mupdateComment(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findCategoryName(int categoryNum) {
		String categoryName = "";
		try {
			categoryName = dreamCategoryDAO.selectCategoryBycategoryNum(categoryNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryName;
	}

	@Override
	public List<String> findCategoryList() {
		List<String> categoryList = null;
		try {
			categoryList = dreamCategoryDAO.selectCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

}
