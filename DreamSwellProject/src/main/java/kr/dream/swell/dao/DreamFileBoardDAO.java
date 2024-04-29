package kr.dream.swell.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamSwellFileBoardVO;

@Mapper
public interface DreamFileBoardDAO {
	
	void insert(DreamSwellFileBoardVO fileBoardVO) throws SQLException;
	
	List<DreamSwellFileBoardVO> selectfileByRef(Long ref) throws SQLException;
	
	DreamSwellFileBoardVO selectfileByIdx(Long idx) throws SQLException;

	Long selectCount(HashMap<String,Object> map) throws SQLException;
}
