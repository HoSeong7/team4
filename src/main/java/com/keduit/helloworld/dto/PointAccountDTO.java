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
public class PointAccountDTO {

	/** BankDTO 포인트 충전번호 pk */
	private Long pointNum;
	
	/** BankDTO 포인트 거래내역번호 */
	private Long memberNum;
	
	/** BankDTO 포인트 충전금액 */
	private Long charge;
	
	/** BankDTO 포인트 잔액 */
	private Long balance;
	
	/** BankDTO 포인트 환전금액 */
	private Long exchange;
	
	/** BankDTO 등록날짜 */
	protected LocalDateTime regDate;
	
	/** BankDTO 수정날짜 */
	protected LocalDateTime updateDate;
	
}
