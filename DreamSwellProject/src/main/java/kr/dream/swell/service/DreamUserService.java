package kr.dream.swell.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.dream.swell.dao.DreamUserDAO;
import kr.dream.swell.oauth.NaverResponse;
import kr.dream.swell.oauth.OAuth2Response;
import kr.dream.swell.vo.CommonVO;
import kr.dream.swell.vo.DreamUserVO;
import kr.dream.swell.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DreamUserService extends DefaultOAuth2UserService implements UserDetailsService{
	
	@Autowired
	private DreamUserDAO dreamUserDAO;
	
	// 폼 로그인용
	@Override
	public DreamUserVO loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info(" : " + username + "으로 호출");
		DreamUserVO dreamUserVO = null;
		try {
			if(username.startsWith("naver") || username.startsWith("kakao")) {
				
			}
			dreamUserVO = dreamUserDAO.selectByUsername(username);
			if (dreamUserVO == null) {
				throw new UsernameNotFoundException("지정 아이디가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dreamUserVO;
	}

	@Override
	public DreamUserVO loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		String registrationId = userRequest.getClientRegistration().getRegistrationId(); // naver or kakao
		log.info("attributes => {}", oAuth2User.getAttributes());
		
		
		OAuth2Response oAuth2Response = null;
		if(registrationId.equals("naver")) {
			oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
		} else if(registrationId.equals("kakao")) {
			// oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
		} else {
			return null;
		}
		String role = "ROLE_USER";
		String username = oAuth2Response.getProvider() + "_" + oAuth2Response.getProviderId();
		DreamUserVO dreamUserVO = null;
		try {
			dreamUserVO = dreamUserDAO.selectByUsername(username);
			if(dreamUserVO == null) { // 신규회원인 경우
				dreamUserVO = new DreamUserVO();
				dreamUserVO.setUsername(username);
				dreamUserVO.setPassword(" ");
				dreamUserVO.setNickName(oAuth2Response.getNickName());
				dreamUserVO.setEmail1(" ");
				dreamUserVO.setEmail2(" ");
				dreamUserVO.setProfile(oAuth2Response.getProfileImageUrl());
				dreamUserVO.setRole(role);
				dreamUserDAO.insert(dreamUserVO);
			} else { // 기존 소셜로그인을 한 경우
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dreamUserVO;
	}
	
	public int insert(DreamUserVO memberVO) {
		int result = 0;
		try {
			dreamUserDAO.insert(memberVO);
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int selectCountByUsername(String username) {
		int result = 0;
		try {
			result = dreamUserDAO.selectCountByUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public DreamUserVO selectByIdx(Long idx) {
		DreamUserVO dreamUserVO = null;
		try {
			dreamUserVO = dreamUserDAO.selectByIdx(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dreamUserVO;
	}

	public int update(DreamUserVO memberVO) {
		int result = 0;
		try {
			dreamUserDAO.insert(memberVO);
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(Long idx) {
		int result = 0;
		try {
			dreamUserDAO.delete(idx);
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/*
	 * 여기부터 관리자 페이지?
	 * */
	public PagingVO<DreamUserVO> getUsers(CommonVO cv) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateRole(DreamUserVO memberVO) {
		// TODO Auto-generated method stub
		
	}

}
