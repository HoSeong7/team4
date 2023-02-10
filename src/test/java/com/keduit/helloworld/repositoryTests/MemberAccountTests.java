package com.keduit.helloworld.repositoryTests;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.MemberAccount;
import com.keduit.helloworld.repository.MemberAccountRepository;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class MemberAccountTests {

	@Autowired
	private MemberAccountRepository memberAccountRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void insertAccount() {
		
		IntStream.rangeClosed(6, 106).forEach(i->{
			
			Long a = (long)(Math.random()*10)+1;
			Long b = (long)(Math.random()*10)+1;
			
			MemberAccount entity = MemberAccount.builder()
					.memberBuyer(a)
					.memberSeller(b)
					.payment(i*1000L)
					.build();
			memberAccountRepository.save(entity);
			
		});
	}
	
	@Test
	public void selectAccountList() {
		
		long memNum = 5;
		List<MemberAccount> result1 = memberAccountRepository.getPayListAsBuyer(memNum);
		List<Member> result2 = memberRepository.getMemNum(memNum);
		
		for(int i = 0; i <= result1.size()-1; i++) {
			System.out.println(result1.get(i).getRegDate() + ", " + 
								result1.get(i).getPayment() + ", " + 
								result2.get(i).getId()
								);
		}
	}
	
	
}
