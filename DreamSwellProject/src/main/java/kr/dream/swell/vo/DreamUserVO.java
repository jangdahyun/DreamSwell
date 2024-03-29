package kr.dream.swell.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class DreamUserVO implements UserDetails, OAuth2User{
	private static final long serialVersionUID = 1L;
	
	private Long idx;
	private String username;		// 아이디
	private String password;		// 비번
	private String nickName;		// 닉네임
	private String email1;			// 이메일
	private String email2;			// 도메인
	private String profile;			// 프로필사진
	private String role;			// 권한
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authoritys = new ArrayList<>();
		authoritys.add(new SimpleGrantedAuthority(role));
		return authoritys;
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
