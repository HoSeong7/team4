package com.keduit.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Bank extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** Bank 포인트 충전번호 pk,nn,ai */
	private Integer bankNum;
	
	@Column(nullable = false) 
	/** Bank 포인트 거래내역번호 fk */
	private Integer accountNum; //회원번호(멤버):거래내역 = 1:n
	
	@Column
	/** Bank 포인트 충전금액 */
	private Integer bankCashPoint;
	
	@Column(nullable = false)
	/** Bank 포인트 잔액 nn */
	private Integer bankPoint;
	
	@Column
	/** Bank 포인트 환전금액 */
	private Integer bankPointCash;
	
}
