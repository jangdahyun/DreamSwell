package kr.dream.swell.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamUserVO;

@Mapper
public interface DreamUserDAO {
	DreamUserVO selectByUsername(String username) throws SQLException;
	
	void insert(DreamUserVO dreamUserVO) throws SQLException;
}
