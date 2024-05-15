package kr.dream.swell.service;

import java.util.List;

import kr.dream.swell.vo.DreamSwellBoardVO;

public interface DreamSwellBoardService {
	// 1. 페이징
	List<DreamSwellBoardVO> selectScrollBoard(Long lastItemIdx, int sizeOfPage, Integer categoryNum, String search, String endDate, String end);
	
	Long findLastItemIdx();
	// 2. 한개얻기
	DreamSwellBoardVO selectByIdx(Long idx);

	// 3. 저장
	void insert(DreamSwellBoardVO boardVO);
	
	// 5. 게시글 삭제
	void delete(Long idx);
	
	//5-1 userRef를 통한 게시글 삭제
	void deleteByUserRef(Long ref);
	
	// 6.수정
	void update(DreamSwellBoardVO boardVO);
	
	//7. 좋아요 누르기
	void updateLove(Long idx);
	
	//8. 댓글 쓴 개수
	void pupdateComment(Long idx);
	
	//9. 댓글 썼다 지운 다음 개수
	void mupdateComment(Long idx);
	
	
	

	// 카테고리 불러오기
	String findCategoryName(int categoryNum);
	
	List<String> findCategoryList();


	
	
}
