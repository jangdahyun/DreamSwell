package kr.dream.swell.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DreamSwellBoardVO {
	private Long idx;
	private Long userRef;			// 유저 왜래키
	private String thumbnail;		// 썸내일
	private String title;			// 제목
	private String content;			// 내용
	private Date regDate;			// 게시일
	private Date stDate;			// 시작일
	private Date endDate;			// 종료일
	private int targetAmount;		// 목표금액
	private int currentAmount;		// 현재금액
	private int love;				// 좋아요수
	private int commentCount;		// 댓글 수 
	private Integer category1;		// 테그1
	private Integer category2;		// 테그2
	private Integer category3;		// 테그3
	//DB설계 끝
	
	private List<DreamSwellCategoryVO> categoryName1;	// 카테고리 이름
}
