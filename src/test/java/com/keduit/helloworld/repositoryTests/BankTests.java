package com.keduit.helloworld.repositoryTests;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Account;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.BankRepository;

@SpringBootTest
public class BankTests {

	@Autowired
	private BankRepository bankRepository;
	
	@Test
	/** 포인트 정보 등록 테스트(충전 or 환전) */
	public void insertPoint() {
		
		IntStream.rangeClosed(1, 100).forEach(i -> {
			PointAccount entity = PointAccount.builder()
					.accountNum(i)
					.bankCashPoint(1000*i)
					.bankPoint(4000)
					.bankPointCash(0)
					.build();
			bankRepository.save(entity);
		});
	}
		
	@Test
	/** 포인트 거래 내역 조회 */
	public void selectPointList() {
		List<PointAccount> result = bankRepository.getPointAccount(2);
		
		for(PointAccount i : result) {
			System.out.println(i.toString());
			
		}
		
	}
}
