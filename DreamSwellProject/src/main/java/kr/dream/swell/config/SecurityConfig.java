package kr.dream.swell.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.dream.swell.service.DreamUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private DreamUserService dreamUserService;
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	// csrf 토근 미 사용
        http.csrf(AbstractHttpConfigurer::disable);
        
        http.httpBasic((basic) -> basic.disable());
        
        http.formLogin((form) -> {
        	form.loginPage("/login").permitAll()
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/")
				.successHandler(new LoginSuccessHandler());
        });

        
        
        http.oauth2Login((oauth2) -> { // oauth2Login 자동세팅 oauth2Client 세팅해줘야함
        	oauth2
        		.loginPage("/login").permitAll() // 내 로그인페이지 사용
        		.userInfoEndpoint((userInfoEndpointConfig) -> {
        			userInfoEndpointConfig.userService(dreamUserService);
        		})
        		.successHandler(new LoginSuccessHandler());
        });
        
        http.logout((logout) -> {
        	logout.permitAll()
        		.logoutSuccessUrl("/") // 로그아웃후 가는 주소
        		.invalidateHttpSession(true); // 세션날리기
        });

        
        
        
        http.authorizeHttpRequests((auth) -> {
        	auth
        		.requestMatchers("/dbinit").permitAll()
	        	.requestMatchers("/", "/oauth2/**", "/login/**").permitAll()
	        	.requestMatchers("/images/**").permitAll()
	        	.anyRequest().authenticated();
        });

        return http.build();
    }
    
    // DB에 저장된 비번과 같은지 확인하는 
 	// JDBC인증
 	@Autowired
 	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(dreamUserService).passwordEncoder(new BCryptPasswordEncoder());
    }
 	
 	// 암호화 객체 등록 
 	@Bean(value = "passwordEncoder")
 	BCryptPasswordEncoder getBCryptPasswordEncoder() {
 		return new BCryptPasswordEncoder();
 	}
}
