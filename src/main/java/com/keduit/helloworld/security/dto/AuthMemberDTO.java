package com.keduit.helloworld.security.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthMemberDTO extends User implements OAuth2User{

	private String email;
	private String pw;
	private String name;
	private boolean purview;
	
	private Map<String, Object> attr;
	
	public AuthMemberDTO(String email,
						 String id,
						 String name,
						 String pw,
						 String nickname,
						 boolean purview,
						 Collection<? extends GrantedAuthority> authorities) {
		super(name, pw, authorities);
		this.pw = pw;
		this.email = name;
		this.purview = purview;
	}
	
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attr;
	}
	
	public AuthMemberDTO(String email,
						 String id,
						 String name,
					 	 String pw,
						 String nickname,
						 boolean purview,
						 Collection<? extends GrantedAuthority> authorities,
						 Map<String, Object> attr) {
		this(email, id, name, pw, nickname, purview, authorities);
		this.attr = attr;
	}
}
