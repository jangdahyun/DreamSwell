package kr.dream.swell.oauth;

public interface OAuth2Response {
	
	String getProvider(); // 제공자이름 ex) naver, kakao
	
	String getProviderId();
	
	String getEmail();
	
	String getNickName();
	
	String getProfileImageUrl();
	
}
