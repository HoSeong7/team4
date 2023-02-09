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
public class BankDTO {

	/** BankDTO 포인트 충전번호 pk */
	private Integer bankNum;
	
	/** BankDTO 포인트 거래내역번호 */
	private Integer accountNum;
	
	/** BankDTO 포인트 충전금액 */
	private Integer bankCashPoint;
	
	/** BankDTO 포인트 잔액 */
	private Integer bankPoint;
	
	/** BankDTO 포인트 환전금액 */
	private Integer bankPointCash;
	
	/** BankDTO 등록날짜 */
	protected LocalDateTime regDate;
	
	/** BankDTO 수정날짜 */
	protected LocalDateTime updateDate;
	
}
