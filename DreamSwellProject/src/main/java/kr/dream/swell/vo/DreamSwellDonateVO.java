package kr.dream.swell.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DreamSwellDonateVO {
	private Long idx;
	private Long userRef;			// 유저 왜래키
	private Long boardRef;			// 게시글왜래키
	private int donate;				// 후원금액
	private String content;			// 내용
	private Date regDate;			// 후원일
}
