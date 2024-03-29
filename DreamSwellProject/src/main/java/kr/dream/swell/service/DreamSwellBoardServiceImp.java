package kr.dream.swell.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.dream.swell.dao.DreamBoardDAO;
import kr.dream.swell.vo.DreamSwellBoardVO;

@Service(value = "dreamSwellBoardService")
public class DreamSwellBoardServiceImp implements DreamSwellBoardService{

	@Autowired
	private DreamBoardDAO dreamBoardDAO;
	
	@Override
	public List<DreamSwellBoardVO> selectScrollBoard(Long lastItemIdx, Long sizeOfPage, Integer categoryNum, String search) {
		try {
			ArrayList<DreamSwellBoardVO> list = null;
			HashMap<String, Object> map = new HashMap<>();
			map.put("lastItemIdx", lastItemIdx);
			map.put("sizeOfPage", sizeOfPage);
			map.put("category1", categoryNum);
			map.put("category2", categoryNum);
			map.put("category3", categoryNum);
			map.put("search", search);
			list= dreamBoardDAO.selectScrollList(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int findLastItemIdx() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DreamSwellBoardVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DreamSwellBoardVO jungBoardVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByUserRef(int ref) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DreamSwellBoardVO jungBoardVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLove(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pupdateComment(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mupdateComment(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findCategoryName(int categoryNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
