package com.keduit.helloworld.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
	@Autowired
	private DataSource dataSource;
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.jdbcAuthentication()
//							.dataSource(dataSource)
//							.passwordEncoder(passwordEncoder())
//							.usersByUsernameQuery("select id, pw, purview "
//									+ "from member "
//									+ "where id = ?")
//							.authoritiesByUsernameQuery("select id, name "
//									+ "from member_role_set mr inner join member m on mr.member_member_num = m.member_num "
//									+ "where m.id = ?");
//							
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		log.info("----------- fileterchain -----------");
		
		http.authorizeRequests()
						.antMatchers("/", "/hello/index", "/css/**", "/img/**", "/js/**").permitAll()
						.anyRequest().authenticated()
						.and()
					.formLogin()
						.loginPage("/hello/login")
						.permitAll()
						.and()
					.logout()
						.permitAll();
				
		http.formLogin();										//인가, 인증에 문제가 발생할 때 화면을 띄움
		http.csrf().disable();
		http.logout();
		
		http.oauth2Login().loginPage("/hello/login");         //카카오로그인
		
//		http.rememberMe().tokenValiditySeconds(60*60*7).userDetailsService(userDetailsService); // 토큰 유효시간 7일로 잡음
		
		return http.build();
	}


}
