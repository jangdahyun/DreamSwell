package kr.dream.swell.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamSwellCommentVO;

@Mapper
public interface DreamCommentDAO {
	List<DreamSwellCommentVO> selectByRef(HashMap<String, Object> map) throws SQLException;
	
	List<DreamSwellCommentVO> selectByUserRef(Long userRef) throws SQLException;
	
	void insert(DreamSwellCommentVO dreamSwellCommentVO) throws SQLException;
	
	void update(DreamSwellCommentVO dreamSwellCommentVO) throws SQLException;
	
	void delete(Long idx) throws SQLException;
}
