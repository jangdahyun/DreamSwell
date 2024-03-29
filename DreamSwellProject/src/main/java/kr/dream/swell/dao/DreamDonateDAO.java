package kr.dream.swell.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamSwellDonateVO;

@Mapper
public interface DreamDonateDAO {
	DreamSwellDonateVO selectByBoardRef(Long boardRef) throws SQLException;
	DreamSwellDonateVO selectByUserRef(Long userRef) throws SQLException;
	Long selectCountByUserRef(Long userRef) throws SQLException;
	Long selectCountByBoardRef(Long boardRef) throws SQLException;
	void insert(DreamSwellDonateVO donateVO) throws SQLException;
	void update(DreamSwellDonateVO donateVO) throws SQLException;
}
