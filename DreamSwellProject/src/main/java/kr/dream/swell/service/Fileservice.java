package kr.dream.swell.service;

import java.util.List;

import kr.dream.swell.vo.DreamSwellFileBoardVO;

public interface Fileservice {

	void insert(DreamSwellFileBoardVO fileBoardVO);
	
	List<DreamSwellFileBoardVO> selectfileByRef(Long idx);
	
	DreamSwellFileBoardVO selectfileByIdx(Long idx);
	
}
