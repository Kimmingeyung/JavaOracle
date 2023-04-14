package com.oraclejava.Config;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecuritConfig extends WebSecurityConfigurerAdapter{
	
	// 암호화 모듈 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // 암호화 모듈
	}
	
	//시큐리티 관련 설정 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//직접 접근금지 및 로그인이 필요없는 페이지 설정 
		http
			.csrf().disable()
			.authorizeRequests()
				//.antMatchers("/","/cgv/**").permitAll(); // 홈페이지 및 퍼블릭 페이지 접근 허가 부여
				//.antMatchers("/","/cgv/**","/customers/**").permitAll() // 접근 허가
			.antMatchers("/login").permitAll() // 사용자에게 로그인창 접근권한 허가	
			.antMatchers("/css/**","/images/**").permitAll() // CSS,IMAGES 폴더 접근 허가
				.anyRequest().authenticated(); // 기타 나머지는 직접 접근 금지
		
		//로그인 처리
		http
			.formLogin() //--> 403페이지가 아니라 기본로그인 창으로 이동
		    	.loginProcessingUrl("/login") // 로그인 처리 경로(form action속성 값)
		    	.loginPage("/login") // 로그인 페이지 지정(컨트롤러의 RequestMapping value 값)
		    	.failureUrl("/login?error") // 로그인에 실패할 경우 url
		    	.usernameParameter("userId") // 사용자 id (input type="text" 태그의 name값)
		    	.passwordParameter("password") // 비밀번호(input type ="password" 태그의 name값)
		    	.defaultSuccessUrl("/", true) // 로그인 성공시 이동하는 url(보통 홈페이지), true=> 무조건 홈으로 이동
		    									// false=> 요청하는 url에 따라 달라짐
			.and().httpBasic(); 
		
		
		
	}

	// 회원 검증 	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("oracle").password(passwordEncoder().encode("java")).roles("USER");
	}
	
}

