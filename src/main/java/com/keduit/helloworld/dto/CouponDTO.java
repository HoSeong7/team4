package com.keduit.helloworld.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO {

	private Integer couponNum; //쿠폰 고유번호
	private Integer couponPoint; //쿠폰금액
	private String couponNumber; //쿠폰번호
	private Integer booleanNum; //사용여부
	
}
