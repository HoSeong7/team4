package com.keduit.helloworld.repositoryTests;


import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.MemberRole;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class MemberInsertTest2 {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void insertTest() {
		IntStream.rangeClosed(20, 30).forEach(i->{
			Member member = Member.builder().id("user"+i)
					.name("이름"+i)
					.pw(passwordEncoder.encode("1111"))
					.nickname("닉네임"+i)
					.email(i + "@abc.com")
					.exvalue(500L)
					.purview(false)
					.build();
				member.addMemberRole(MemberRole.USER);
				memberRepository.save(member);
		});
		
	}
	
	@Test
	public void testRead() {
		Optional<Member> result = memberRepository.findByEmail("2aa", false);
		Member member = result.get();
		
		System.out.println("맴버 읽어올 수 있는지 : " + member);
		
		
	}
}
