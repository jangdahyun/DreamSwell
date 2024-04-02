package kr.dream.swell.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.dream.swell.dao.DreamCommentDAO;
import kr.dream.swell.dao.DreamUserDAO;
import kr.dream.swell.vo.CommonVO;
import kr.dream.swell.vo.DreamSwellBoardVO;
import kr.dream.swell.vo.DreamSwellCommentVO;
import kr.dream.swell.vo.PagingVO;

@Service(value = "commentService")
public class DreamSwellCommentServiceImp implements DreamSwellCommentService{

	@Autowired
	private DreamCommentDAO dreamCommentDAO;
	
	@Autowired
	private DreamUserDAO dreamUserDAO;
	
	@Override
	public PagingVO<DreamSwellCommentVO> selectByRef(Long boardRef, CommonVO cv) {
		PagingVO<DreamSwellCommentVO> pv = null;
		try {
			DreamSwellBoardVO boardVO = new DreamSwellBoardVO();
			HashMap<String, Object> map = new HashMap<>();
			pv= new PagingVO<>(boardVO.getCommentCount(), cv.getCurrentPage(), cv.getSizeOfPage(), cv.getSizeOfBlock());
			map.put("boardRef", boardRef);
			map.put("startNo", pv.getStartNo());
			map.put("sizeOfPage", pv.getSizeOfPage());
			List<DreamSwellCommentVO> commentList = dreamCommentDAO.selectByRef(map);
			for(DreamSwellCommentVO comment : commentList) {
				//유저 정보
				comment.setMember(dreamUserDAO.selectByIdx(comment.getBoardRef()));
			}
			pv.setList(commentList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pv;
	}

	@Override
	public int insert(DreamSwellCommentVO dreamSwellCommentVO) {
		int result = 0;
		try {
			dreamCommentDAO.insert(dreamSwellCommentVO);
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(DreamSwellCommentVO dreamSwellCommentVO) {
		int result = 0;
		try {
			dreamCommentDAO.update(dreamSwellCommentVO);
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int delete(Long idx) {
		int result = 0;
		try {
			dreamCommentDAO.delete(idx);
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
