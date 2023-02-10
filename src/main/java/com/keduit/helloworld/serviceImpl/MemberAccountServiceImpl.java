package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MemberAccountDTO;
import com.keduit.helloworld.entity.MemberAccount;
import com.keduit.helloworld.repository.MemberAccountRepository;
import com.keduit.helloworld.service.MemberAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
<<<<<<< HEAD
public class MemberAccountServiceImpl implements MemberAccountService {

	private final MemberAccountRepository repository;
	
	@Override
	public Long register(MemberAccountDTO dto) {
		log.info("MemberAccount ServiceImpl register");
		
		MemberAccount entity = memberAccountDtoToEntity(dto);
		
		repository.save(entity);
		return entity.getAccountNum();
	}

	@Override
	public List<MemberAccount> read(Long accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

=======
public class MemberAccountServiceImpl implements MemberAccountService {@Override
	public Long register(MemberAccountDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberAccount> read(Long accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

//	private final MemberAccountRepository repository;
//	
//	@Override
//	public Long register(MemberAccountDTO dto) {
//		log.info("AccountServiceImpl register");
//		
//		MemberAccount entity = accountDtoToAccountEntity(dto);
//		
//		repository.save(entity);
//		return entity.getAccountNum();
//	}
//
//	@Override
//	public List<MemberAccount> read(Long accountNum) {
//		// TODO Auto-generated method stub
//		return null;
//	}
>>>>>>> branch 'HW_HS' of https://github.com/HoSeong7/team4.git
	
//	public List<Object> list(){
//		
//		List<Object> list = repository.list();
//		
//		return list;
//	}

}
