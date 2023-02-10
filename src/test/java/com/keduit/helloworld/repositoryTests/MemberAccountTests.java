package com.keduit.helloworld.repositoryTests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.MemberAccount;
import com.keduit.helloworld.repository.MemberAccountRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberAccountTests {

	@Autowired
	private MemberAccountRepository repository;
	
	@Test
	public void insertAccount() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			MemberAccount entity = MemberAccount.builder()
<<<<<<< HEAD
					.memberBuyer(i + 0L)
					.memberSeller(i + 0L)
					.payment(500L)
=======
					.memberBuyer(i*2L)
					.memberSeller(i*5L)
					.payment(i*1000L)
>>>>>>> branch 'HW_HS' of https://github.com/HoSeong7/team4.git
					.build();
			repository.save(entity);
			
		});
	}
	
//	@Test
//	public void insertAccount3() {
//		
//		List<Object> list = repository.list();
//		
//		for (int i = 0; i < 10; i++) {
//			
//			log.info(list.get(i).toString());
//		}
//	}
	
	
}
