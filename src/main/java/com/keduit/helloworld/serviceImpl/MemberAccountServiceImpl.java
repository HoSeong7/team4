package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MemberAccountDTO;
import com.keduit.helloworld.entity.MemberAccount;
import com.keduit.helloworld.repository.MemberAccountRepository;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.MemberAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberAccountServiceImpl implements MemberAccountService {

	private final MemberAccountRepository memberAccountRepository;
	
	private MemberRepository memberRepository;
	
	@Override
	/** 회원간 거래내역 등록(create) */
	public Long register(MemberAccountDTO dto) {
		
		log.info("MemberAccount ServiceImpl register");
		
		MemberAccount entity = memberAccountDtoToEntity(dto);
		
		memberAccountRepository.save(entity);
		
		return entity.getAccountNum();
	}
	
	@Override
	/** 회원간 거래내역 리스트 조회(read, 구매자=질문자 기준) */
	public List<MemberAccount> getListAsBuyer(Long buyerNum) {
		
		List<MemberAccount> result = memberAccountRepository.getPayListAsBuyer(buyerNum);
		return result;
	}
	
	@Override
	/** 회원간 거래내역 리스트 조회(read, 판매자=답변자 기준) */
	public List<MemberAccount> getListAsSeller(Long sellerNum) {
		
		List<MemberAccount> result = memberAccountRepository.getPayListAsSeller(sellerNum);
		return result;
	}


}
