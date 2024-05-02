package kr.dream.swell.oauth;

import java.util.Map;

public class NaverResponse implements OAuth2Response {

	private final Map<String, Object> attribute;
	
	public NaverResponse(Map<String, Object> attribute) {
		this.attribute = (Map<String, Object>) attribute.get("response");
	}
	
	@Override
	public String getProvider() {
		return "naver";
	}

	@Override
	public String getProviderId() {
		return attribute.get("id").toString();
	}

	@Override
	public String getEmail() {
		return attribute.get("email").toString();
	}

	@Override
	public String getNickName() {
		return attribute.get("name").toString();
	}
	 @Override
	    public String getProfileImageUrl() {
	        // 네이버 API에서 프로필 이미지 URL을 가져와야 함
	        // attribute에서 해당 정보를 추출하거나, API를 호출하여 가져올 수 있음
	        // 이 예시에서는 attribute에서 프로필 이미지 URL을 추출하는 것으로 가정
	        return attribute.get("profile_image").toString();
	    }

}
