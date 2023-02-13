package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.PointAccountRepository;
import com.keduit.helloworld.service.PointAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointAccountServiceImpl implements PointAccountService {

	private final PointAccountRepository repository;
	
	@Override
	/** (DTO에서 Entity로) 포인트 거래내역 등록(create) */
	public Long register(PointAccountDTO dto) {
		
		log.info("PointAccount ServiceImpl ---------- : " + dto);
		
		PointAccount entity = pointAccountDtoToEntity(dto);
		log.info("PointAccount DTO 에서 Entity로 값 넣기 : " + entity);
		
		repository.save(entity);
		
		return entity.getMemberNum();
	}

	@Override
	/** (Entity 정보로) 포인트 거래내역 리스트 조회(read) */
	public List<PointAccount> read(Long num) {
		
		List<PointAccount> result = repository.getPointAccount(num);
		
		return result;
	}
}
