package com.keduit.helloworld.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {

	private Integer bankNum; //충전번호
	private Integer accountNum; //거래번호
	private Integer bankCashPoint; //충전금액
	private Integer bankPoint; //잔액
	private Integer bankPointCash; //환전금액
	protected LocalDateTime regDate; //등록날짜
	protected LocalDateTime updateDate; //수정날짜
	
}
