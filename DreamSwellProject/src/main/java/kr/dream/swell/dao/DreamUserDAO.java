package kr.dream.swell.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.dream.swell.vo.DreamUserVO;

@Mapper
public interface DreamUserDAO {
	DreamUserVO selectByUsername(String username) throws SQLException;
	
	/** 저장 */
	void insert(DreamUserVO dreamUserVO) throws SQLException;
	
	/** 하나 얻기 */
	DreamUserVO selectByIdx(Long idx) throws SQLException;
	
	/** 아이디 중복방지 */
	int selectCountByUsername(String username) throws SQLException;
	
	/** (idx + nickName or profile or password) */
	void update(DreamUserVO dreamUserVO) throws SQLException;
	
	/** 삭제 */
	void delete(Long idx) throws SQLException;
	
	/** 등록된 email인지 확인? */
	int emailCheck(HashMap<String, String> map) throws SQLException;
}
