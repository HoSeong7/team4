package com.keduit.helloworld.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecyrityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.	authorizeHttpRequests()
						.antMatchers("/hello/index", "/css/**", "/img/**", "/js/**", "/hello/register", "/hello/**").permitAll()
						.anyRequest().authenticated()
						.and()
				.formLogin()
						.loginPage("/hello/login")
						.permitAll()
						.and()
				.logout()
						.permitAll();
		
	}
	/** Authentication = 로그인  Authroization = 권한*/
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
//	      .passwordEncoder(passwordEncoder())
	      .usersByUsernameQuery("select id,pw,purview "
	        + "from member "
	        + "where id = ?")
	      .authoritiesByUsernameQuery("select id,user_role "
	        + "from user_role ur inner join member m on ur.user_id = m.id "
	        + "inner join role r on ur.role = r.id "
	        + "where id = ?");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
