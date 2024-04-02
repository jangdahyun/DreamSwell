package kr.dream.swell.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DreamSwellCommentVO {
	private Long idx;			
	private Long userRef;		// 유저 왜래키
	private Long boardRef;		// 게시글 왜래키
	private Date regDate;		// 게시일
	private String content;		// 내용
	
	private DreamUserVO member;
}
