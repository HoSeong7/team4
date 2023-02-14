package com.keduit.helloworld.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.keduit.helloworld.security.service.UserDetailsService;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		log.info("----------- fileterchain -----------");
		http.formLogin().loginPage("/hello/login");
		
		http.authorizeHttpRequests((auth) -> {
			auth.antMatchers("/hello/index").permitAll();			// 접근권한 all -> 전체 / hasRole USER -> USER
			auth.antMatchers("/hello/member").hasRole("USER");
			auth.antMatchers("/hello/admin").hasRole("ADMIN");
			
		});
		http.formLogin();										//인가, 인증에 문제가 발생할 때 화면을 띄움
		http.csrf().disable();
		http.logout();
		
		http.oauth2Login().loginPage("/hello/login");         //카카오로그인
		
		http.rememberMe().tokenValiditySeconds(60*60*7).userDetailsService(userDetailsService); // 토큰 유효시간 7일로 잡음
		
		return http.build();
	}

//	@Bean
//	public ClubLoginSuccessHandler successHandler() {
//
//		
//		return new ClubLoginSuccessHandler(passwordEncoder());
//	}
	
	
}
