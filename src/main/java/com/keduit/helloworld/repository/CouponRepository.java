package com.keduit.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keduit.helloworld.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{

	
}
