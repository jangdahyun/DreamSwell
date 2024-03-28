package kr.dream.swell.vo;

import lombok.Data;

@Data
public class DreamUserVO {
	private Long idx;
	private String username;		// 아이디
	private String password;		// 비번
	private String email1;			// 이메일
	private String email2;			// 도메인
	private String prifile;			// 프로필사진
}
