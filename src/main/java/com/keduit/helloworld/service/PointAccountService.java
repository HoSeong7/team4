package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;

public interface PointAccountService {
	
	/** 포인트 거래내역 등록(create) */
	Long register(PointAccountDTO dto); 
	
	/** 포인트 거래내역 리스트 조회(read) */
	List<PointAccountDTO>read(Long memberNum);
	
	/** DTO에 있는 정보를 Entity로 옮기기 */
	default PointAccount pointAccountDtoToEntity(PointAccountDTO dto) {
		
		PointAccount entity = PointAccount.builder()
				.pointNum(dto.getPointNum())
				.memberNum(dto.getMemberNum())
				.charge(dto.getCharge())
				.balance(dto.getBalance())
				.exchange(dto.getExchange())
				.build();
		return entity;
	}
	
	/** Entity에 있는 정보를 DTO로 옮기기 */
	default PointAccountDTO pointAccountEntityToDto(PointAccount entity) {
		
		PointAccountDTO dto = PointAccountDTO.builder()
				.pointNum(entity.getPointNum())
				.memberNum(entity.getMemberNum())
				.charge(entity.getCharge())
				.balance(entity.getBalance())
				.exchange(entity.getExchange())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	
}


