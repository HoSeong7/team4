package com.keduit.helloworld.repositoryTests;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.PointAccountRepository;

@SpringBootTest
public class PointAccountTests {

	@Autowired
	private PointAccountRepository repository;
	
	@Test
	/** 포인트 거래내역 등록 테스트(create) */
	public void insertPoint() {
		
		IntStream.rangeClosed(1, 30).forEach(i -> {
			PointAccount entity = PointAccount.builder()
					.charge(4000L)
					.balance(1000L*i)
					.exchange(0L)
					.memberNum((long)i)
					.build();
			repository.save(entity);
		});
	}
		
	@Test
	/** 포인트 거래내역 조회(read) */
	public void selectPointList() {
		
		List<PointAccount> result = repository.getPointAccount(2L);
		
		for(PointAccount i : result) {
			System.out.println(i);
			
//			System.out.println(i.getRegDate() + ", " +
//					   i.getCharge() + ", " +
//					   i.getExchange() + ", " +
//					   i.getBalance());
		}
	}
	
	
}
