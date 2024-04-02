package kr.dream.swell.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.dream.swell.vo.DreamSwellCommentVO;

@RestController
public class CommentController {
	
	/**
	 * 댓글을 날려주는 주소 
	 * 요청예시 ) /comments?boardRef=123&lastItemIdx=123&sizeOfPage=20
	 */
	@GetMapping(value = "/comments")
	public List<DreamSwellCommentVO> getCommentList(
			@RequestParam(value = "boardRef") Long boardRef,
			@RequestParam(value = "lastItemIdx") Long lastItemIdx,
			@RequestParam(value = "sizeOfPage") int sizeOfPage){
		List<DreamSwellCommentVO> list = null;
		
		return list;
	}
	/**
	 * 댓글을 저장시키는 
	 */
	@PostMapping(value = "/comment")
	public int uploadComment(@RequestBody DreamSwellCommentVO dreamSwellCommentVO){
		int result = 0;
		return result;
	}
	
	/**
	 * 댓글 수정
	 */
	@PutMapping(value = "/comment")
	public int updateComment(@RequestBody DreamSwellCommentVO dreamSwellCommentVO) {
		int result = 0;
		return result;
	}
	
	/**
	 * 댓글 삭제
	 */
	@DeleteMapping(value = "/comment")
	public int deleteComment() {
		int result = 0;
		return result;
	}
}
