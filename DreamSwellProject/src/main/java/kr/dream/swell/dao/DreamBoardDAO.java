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
	Long findLastItemIdx() throws SQLException;
	
	DreamSwellBoardVO selectByIdx(Long idx) throws SQLException;
	Long selectCount(HashMap<String, Object> map) throws SQLException;
	void insert(DreamSwellBoardVO boardVO) throws SQLException;
	void update(DreamSwellBoardVO boardVO) throws SQLException;
	void delete(Long idx) throws SQLException;
	void deleteByUserRef(Long userRef) throws SQLException;
	void updateLove(Long idx) throws SQLException;
	void pupdateComment(Long idx) throws SQLException;
	void mupdateComment(Long idx) throws SQLException;
}
