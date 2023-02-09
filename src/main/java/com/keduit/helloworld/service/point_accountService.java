package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;

public interface point_accountService {
	
	/** 포인트 충전 or 환전 등록(create) */
	Long register(PointAccountDTO dto); 
	
	/** 포인트 충전 or 환전 내역 조회(read) */
	List<PointAccount>read(Long pointNum);
	
	/** BankEntity에 있는 정보를 BankDTO로 옮기기 */
	default PointAccountDTO bankEntityToBankDto(PointAccount entity) {
		
		PointAccountDTO dto = PointAccountDTO.builder()
				.pointNum(entity.getPointNum())
				.charge(entity.getCharge())
				.balance(entity.getBalance())
				.exchange(entity.getExchange())
				.memberNum(entity.getMemberNum())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	/** BankDTO에 있는 정보를 BankEntity로 옮기기 */
	default PointAccount bankDtoToBankEntity(PointAccountDTO dto) {
		
		PointAccount entity = PointAccount.builder()
				.pointNum(dto.getPointNum())
				.charge(dto.getCharge())
				.balance(dto.getBalance())
				.exchange(dto.getExchange())
				.memberNum(dto.getMemberNum())
				.build();
		return entity;
	}
	
}


