package com.oraclejava.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
				.antMatchers("/","/cgv/**","/customers/**").permitAll() // 접근 허가
				.antMatchers("/css/**","/images/**").permitAll() // CSS,IMAGES 폴더 접근 허가
				.anyRequest().authenticated(); // 기타 나머지는 직접 접근 금지
			
	}
	
}

