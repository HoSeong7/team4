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
public class PointAccount extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** 시스템 거래내역 충전번호 pk,nn,ai */
	private Long pointNum;
	
	@Column(nullable = false) 
	/** 시스템 거래내역  fk nn */
	private Long memberNum; //회원번호(멤버):거래내역 = 1:n
	
	@Column
	/** 시스템 거래내역 충전금액 */
	private Long charge;
	
	@Column(nullable = false)
	/** 시스템 거래내역 잔액 nn */
	private Long balance;
	
	@Column
	/** 시스템 거래내역 환전금액 */
	private Long exchange;

	
}