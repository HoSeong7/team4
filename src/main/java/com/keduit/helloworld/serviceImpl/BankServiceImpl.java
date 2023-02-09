package com.keduit.helloworld.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.BankDTO;
import com.keduit.helloworld.entity.Account;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.BankRepository;
import com.keduit.helloworld.service.BankService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BankServiceImpl implements BankService {

	private final BankRepository bankRepository;
	
	@Override
	/** DTO에서 Entity로 포인트 정보 등록 */
	public Integer register(BankDTO dto) {
		log.info("Bank ServiceImpl ---------- : " + dto);
		
		PointAccount entity = bankDtoToBankEntity(dto);
		log.info("Bank DTO 에서 Entity로 값 넣기 : " + entity);
		
		bankRepository.save(entity);
		return entity.getBankNum();
	}

	@Override
	/** Entity 정보로 포인트 거래내역 조회 */
	public List<PointAccount> read(Integer memberNum) {
		
		List<PointAccount> result = bankRepository.getPointAccount(memberNum);
		
		return result;
	}

}
