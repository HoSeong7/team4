package com.keduit.helloworld.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	
	private Integer accountNum; //거래내역번호
	private Integer memberBuyer; //구매회원(질문자)
	private Integer memberSeller; //판매회원(답변자)
	private Integer cash; //거래금액
	protected LocalDateTime regDate; //등록날짜
	protected LocalDateTime updateDate; //수정날짜
	
}
