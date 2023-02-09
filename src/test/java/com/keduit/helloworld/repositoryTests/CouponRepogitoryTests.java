package com.keduit.helloworld.repositoryTests;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Coupon;
import com.keduit.helloworld.repository.CouponRepository;

@SpringBootTest
public class CouponRepogitoryTests {

	@Autowired
	private CouponRepository repository;
	
	@Test
	public void insertCoupon() {
		
		IntStream.rangeClosed(11, 20).forEach(i -> {
		
			UUID uid = UUID.randomUUID();
			String id = uid.toString();
		
			System.out.println(id);
//			Coupon entity = Coupon.builder().couponPoint(100000)
//											.couponNumber(id)
//											.build();
//			repository.save(entity);
		});
	}
	
	@Test
	public void selectAll() {
		List<Coupon> result = repository.findAll();
		
		for(Coupon c : result) {
			System.out.println(c);
		}
		
	}
}
