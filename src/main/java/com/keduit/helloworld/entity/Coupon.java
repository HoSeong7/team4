package com.keduit.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** coupon 고유번호 pk */
	private Integer couponNum;
	
	@ColumnDefault("0")
	/** coupon 쿠폰금액 */
	private Integer couponPoint;
	
	@Column(length = 20, unique = true, nullable = false)
	/** coupon 쿠폰번호(사용되는 쿠폰의 번호임) */
	private String couponNumber;
	
	@ColumnDefault("0")
	/** coupon 0사용가능 1사용불능 */
	private Integer booleanNum;
	
}
