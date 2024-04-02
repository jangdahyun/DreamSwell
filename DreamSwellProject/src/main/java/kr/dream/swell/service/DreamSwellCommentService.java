package kr.dream.swell.service;

import kr.dream.swell.vo.CommonVO;
import kr.dream.swell.vo.DreamSwellCommentVO;
import kr.dream.swell.vo.PagingVO;

public interface DreamSwellCommentService {
	//게시물 댓글 가져오기
	PagingVO<DreamSwellCommentVO> selectByRef(Long boardRef, CommonVO cv);
	//저장
	int insert(DreamSwellCommentVO dreamSwellCommentVO);
	//수정
	int update(DreamSwellCommentVO dreamSwellCommentVO);
	//삭제
	int delete(Long idx);
}
