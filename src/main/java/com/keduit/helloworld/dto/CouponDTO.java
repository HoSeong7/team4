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

	/** CouponDTO 고유번호 pk */
	private Integer couponNum;
	
	/** CouponDTO 쿠폰금액 */
	private Integer couponPoint;
	
	/** CouponDTO 쿠폰번호(사용되는 쿠폰의 번호) */
	private String couponNumber;
	
	/** CouponDTO 사용여부 0사용가능 1사용불가 */
	private Integer booleanNum;
	
}
