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
public class Account extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //pk,nn,ai
	private Integer accountNum; //거래내역번호
	
	@Column(nullable = false) //fk,nn | 회원번호(멤버):구매회원(질문자) = 1:n
	private Integer memberBuyer; //구매회원(질문자)
	
	@Column(nullable = false) //fk,nn | 회원번호(멤버):판매회원(답변자) = 1:n
	private Integer memberSeller; //판매회원(답변자)
	
	@Column(nullable = false) //nn
	private Integer cash; //거래금액
	
}
