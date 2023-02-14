package com.keduit.helloworld.repositoryTests;

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
		IntStream.rangeClosed(1, 100).forEach(i->{
			Member member = Member.builder().id(i+"email")
					.name(i+"이름")
					.pw(passwordEncoder.encode("1111"))
					.nickname(i+"email")
					.email(i + "@abc.com")
					.build();
				member.addMemberRole(MemberRole.USER);
				memberRepository.save(member);
		});
		
	}
}
