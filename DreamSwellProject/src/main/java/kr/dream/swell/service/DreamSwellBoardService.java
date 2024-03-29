package kr.dream.swell.service;

import java.util.List;

import kr.dream.swell.vo.DreamSwellBoardVO;

public interface DreamSwellBoardService {
	// 1. 페이징
	List<DreamSwellBoardVO> selectScrollBoard(int lastItemIdx, int sizeOfPage, Integer categoryNum, String search);
	
	int findLastItemIdx();
	// 2. 한개얻기
	DreamSwellBoardVO selectByIdx(int idx);

	// 3. 저장
	void insert(DreamSwellBoardVO jungBoardVO);
	
	// 5. 게시글 삭제
	void delete(int idx);
	
	//5-1 userRef를 통한 게시글 삭제
	void deleteByUserRef(int ref);
	
	// 6.수정
	void update(DreamSwellBoardVO jungBoardVO);
	
	//좋아요  개수 
	int countHeart(int idx);
	
	//좋아요 누르기
	void updateLove(int idx);

	// 카테고리 불러오기
	String findCategoryName(int categoryNum);
	
	
}
