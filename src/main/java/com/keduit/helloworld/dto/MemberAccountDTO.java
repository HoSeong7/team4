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
public class MemberAccountDTO {
	
	/** AccountDTO 거래내역번호 pk */
	private Long accountNum;
	
	/** AccountDTO 구매회원(질문자) */
	private Long memberBuyer;
	
	/** AccountDTO 판매회원(답변자) */
	private Long memberSeller;
	
	/** AccountDTO 거래금액 */
	private Long payment;
	
	/** AccountDTO 등록날짜 */
	protected LocalDateTime regDate;
	
	/** AccountDTO 수정날짜 */
	protected LocalDateTime updateDate;
	
}
