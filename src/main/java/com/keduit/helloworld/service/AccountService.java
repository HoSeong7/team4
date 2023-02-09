package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.AccountDTO;
import com.keduit.helloworld.entity.Account;

public interface AccountService {

	/** 거래 내역 등록(create) */
	Integer register(AccountDTO dto);
	
	/** 거래 내역 조회(read) */
	List<Account> read(Integer accountNum);
	
	/** AccountEntity에 있는 정보를 AccountDTO로 옮기기 */
	default AccountDTO accountEntityToAccountDto(Account entity) {
		
		AccountDTO dto = AccountDTO.builder()
				.accountNum(entity.getAccountNum())
				.memberBuyer(entity.getMemberBuyer())
				.memberSeller(entity.getMemberSeller())
				.cash(entity.getCash())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	/** AccountDTO에 있는 정보를 AccountEntity로 옮기기 */
	default Account accountDtoToAccountEntity(AccountDTO dto) {
		
		Account entity = Account.builder()
				.accountNum(dto.getAccountNum())
				.memberBuyer(dto.getMemberBuyer())
				.memberSeller(dto.getMemberSeller())
				.cash(dto.getCash())
				.build();
		return entity;
	}
}
