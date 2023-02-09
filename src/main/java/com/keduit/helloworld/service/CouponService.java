package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.CouponDTO;
import com.keduit.helloworld.entity.Coupon;

public interface CouponService {

	/**쿠폰 생성*/
	Integer register(CouponDTO dto);
	
	/**전체 쿠폰 읽어오기*/
	List<Coupon> read();
	
	/** 쿠폰 삭제*/
	void remove(Integer couponNum);
	
	/**쿠폰 entity -> 쿠폰 DTO*/
	default CouponDTO EntityToDto(Coupon entity) {
		
		CouponDTO dto = CouponDTO.builder().couponNum(entity.getCouponNum())
											.couponPoint(entity.getCouponPoint())
											.couponNumber(entity.getCouponNumber())
											.booleanNum(entity.getBooleanNum())
											.build();
		return dto;
	}
	
	/**쿠폰DTO -> 쿠폰Entity*/
	default Coupon DtoToEntity(CouponDTO dto) {
		
		Coupon entity = Coupon.builder().couponNum(dto.getCouponNum())
										.couponPoint(dto.getCouponPoint())
										.couponNumber(dto.getCouponNumber())
										.booleanNum(dto.getBooleanNum())
										.build();
		return entity;
	}
	
}
