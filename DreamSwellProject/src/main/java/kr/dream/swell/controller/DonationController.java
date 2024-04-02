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
import kr.dream.swell.vo.DreamSwellDonateVO;

@RestController
public class DonationController {
	/**
	 * 후원목록을 날려주는 주소 
	 * 요청예시 ) /donates?boardRef=123&lastItemIdx=123&sizeOfPage=20
	 */
	@GetMapping(value = "/donates")
	public List<DreamSwellDonateVO> getCommentList(
			@RequestParam(value = "boardRef") Long boardRef,
			@RequestParam(value = "lastItemIdx") Long lastItemIdx,
			@RequestParam(value = "sizeOfPage") int sizeOfPage){
		List<DreamSwellDonateVO> list = null;
		
		return list;
	}
	
	/** 후원 저장시키는 */
	@PostMapping(value = "/donate")
	public int uploadComment(@RequestBody DreamSwellCommentVO dreamSwellCommentVO){
		int result = 0;
		return result;
	}
	
	/** 후원 수정 */
	@PutMapping(value = "/donate")
	public int updateComment(@RequestBody DreamSwellCommentVO dreamSwellCommentVO) {
		int result = 0;
		return result;
	}
	
	/** 댓글 삭제 */
	@DeleteMapping(value = "/donate")
	public int deleteComment() {
		int result = 0;
		return result;
	}
}
