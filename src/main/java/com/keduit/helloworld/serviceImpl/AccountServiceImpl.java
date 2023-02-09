package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.AccountDTO;
import com.keduit.helloworld.entity.Account;
import com.keduit.helloworld.repository.AccountRepository;
import com.keduit.helloworld.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountService {

	private final AccountRepository repository;
	
	@Override
	public Integer register(AccountDTO dto) {
		log.info("AccountServiceImpl register");
		
		Account entity = accountDtoToAccountEntity(dto);
		
		repository.save(entity);
		return entity.getAccountNum();
	}

	@Override
	public List<Account> read(Integer accountNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public List<Object> list(){
//		
//		List<Object> list = repository.list();
//		
//		return list;
//	}

}
