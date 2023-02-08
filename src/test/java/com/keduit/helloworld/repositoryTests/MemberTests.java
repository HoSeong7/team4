package com.keduit.helloworld.repositoryTests;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class MemberTests {

	@Autowired
	private MemberRepository repository;
	
	@Test
	public void insertMemberTest() {
		
		IntStream.rangeClosed(1, 5).forEach(i->{
			Member entity = Member.builder()
								  .id("user" + i)
								  .pw("1111")
								  .memberName(i+"이름")
								  .nickname(i+"별명")
								  .introduce("저는 " + i + "입니다 !!")
								  .email(i+"@abc.com")
								  .build();
			repository.save(entity);
		});
	}
	
	
}
