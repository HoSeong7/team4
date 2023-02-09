package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.BankDTO;
import com.keduit.helloworld.entity.Bank;

public interface BankService {
	
	/** 포인트 충전 or 환전 등록(create) */
	Integer register(BankDTO dto); 
	
	/** 포인트 충전 or 환전 내역 조회(read) */
	List<Bank>read(Integer bankNum);
	
	/** BankEntity에 있는 정보를 BankDTO로 옮기기 */
	default BankDTO bankEntityToBankDto(Bank entity) {
		
		BankDTO dto = BankDTO.builder()
				.bankNum(entity.getBankNum())
				.accountNum(entity.getAccountNum())
				.bankCashPoint(entity.getBankCashPoint())
				.bankPoint(entity.getBankPoint())
				.bankPointCash(entity.getBankPointCash())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	/** BankDTO에 있는 정보를 BankEntity로 옮기기 */
	default Bank bankDtoToBankEntity(BankDTO dto) {
		
		Bank entity = Bank.builder()
				.bankNum(dto.getBankNum())
				.accountNum(dto.getAccountNum())
				.bankCashPoint(dto.getBankCashPoint())
				.bankPoint(dto.getBankPoint())
				.bankPointCash(dto.getBankPointCash())
				.build();
		return entity;
	}
	
}


