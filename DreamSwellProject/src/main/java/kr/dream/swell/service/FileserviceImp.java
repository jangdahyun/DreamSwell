package kr.dream.swell.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.dream.swell.dao.DreamFileBoardDAO;
import kr.dream.swell.vo.DreamSwellFileBoardVO;

@Service(value = "fileService")
public class FileserviceImp implements Fileservice {

	@Autowired
	private DreamFileBoardDAO fileBoardDAO; 
	
	@Override
	public void insert(DreamSwellFileBoardVO fileBoardVO) {
		try {
			fileBoardDAO.insert(fileBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DreamSwellFileBoardVO> selectfileByRef(Long idx) {
		List<DreamSwellFileBoardVO> list = null;
		try {
			list=fileBoardDAO.selectfileByRef(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DreamSwellFileBoardVO selectfileByIdx(Long idx) {
		DreamSwellFileBoardVO fileBoardVO = null;
		try {
			fileBoardVO=fileBoardDAO.selectfileByIdx(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileBoardVO;
	}

}
