package com.keduit.helloworld.repositoryTests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Account;
import com.keduit.helloworld.repository.AccountRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AccountTests {

	@Autowired
	private AccountRepository repository;
	
	@Test
	public void insertAccount() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			Account entity = Account.builder()
					.memberBuyer(i*2)
					.memberSeller(i*5)
					.cash(i*1000)
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
