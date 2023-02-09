package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.MemberAccountDTO;
import com.keduit.helloworld.entity.MemberAccount;

public interface MemberAccountService {

	/** 거래 내역 등록(create) */
	Long register(MemberAccountDTO dto);
	
	/** 거래 내역 조회(read) */
	List<MemberAccount> read(Long accountNum);
	
	/** AccountEntity에 있는 정보를 AccountDTO로 옮기기 */
	default MemberAccountDTO accountEntityToAccountDto(MemberAccount entity) {
		
		MemberAccountDTO dto = MemberAccountDTO.builder()
				.accountNum(entity.getAccountNum())
				.memberBuyer(entity.getMemberBuyer())
				.memberSeller(entity.getMemberSeller())
				.payment(entity.getPayment())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	/** AccountDTO에 있는 정보를 AccountEntity로 옮기기 */
	default MemberAccount accountDtoToAccountEntity(MemberAccountDTO dto) {
		
		MemberAccount entity = MemberAccount.builder()
				.accountNum(dto.getAccountNum())
				.memberBuyer(dto.getMemberBuyer())
				.memberSeller(dto.getMemberSeller())
				.payment(dto.getPayment())
				.build();
		return entity;
	}
}
