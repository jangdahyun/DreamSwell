package kr.dream.swell.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamSwellBoardVO;

@Mapper
public interface DreamBoardDAO {
	/**
	 * 
	 * @param (lastItemIdx, sizeOfPage, category1,category2,category3, search)
	 * @return
	 * @throws SQLException
	 */
	ArrayList<DreamSwellBoardVO> selectScrollList(HashMap<String, Object> map) throws SQLException;
	/** board의 최대 idx 리턴 */
	int findLastItemIdx() throws SQLException;
	
	DreamSwellBoardVO selectByIdx(int idx) throws SQLException;
	int selectByIdx(HashMap<String, Object> map) throws SQLException;
	void insert(DreamSwellBoardVO boardVO) throws SQLException;
	void update(DreamSwellBoardVO boardVO) throws SQLException;
	void delete(int idx) throws SQLException;
	void deleteByUserRef(int userRef) throws SQLException;
	void updateLove(int idx) throws SQLException;
	int countHeart(int idx) throws SQLException;
}
