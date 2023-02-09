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
	
	/** AccountDTO 거래내역번호 pk */
	private Integer accountNum;
	
	/** AccountDTO 구매회원(질문자) */
	private Integer memberBuyer;
	
	/** AccountDTO 판매회원(답변자) */
	private Integer memberSeller;
	
	/** AccountDTO 거래금액 */
	private Integer cash;
	
	/** AccountDTO 등록날짜 */
	protected LocalDateTime regDate;
	
	/** AccountDTO 수정날짜 */
	protected LocalDateTime updateDate;
	
}
