package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.PointAccountRepository;
import com.keduit.helloworld.service.point_accountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointAccountServiceImpl implements point_accountService {

	private final PointAccountRepository bankRepository;
	
	@Override
	/** DTO에서 Entity로 포인트 정보 등록 */
	public Long register(PointAccountDTO dto) {
		log.info("Bank ServiceImpl ---------- : " + dto);
		
		PointAccount entity = bankDtoToBankEntity(dto);
		log.info("Bank DTO 에서 Entity로 값 넣기 : " + entity);
		
		bankRepository.save(entity);
		return entity.getPointNum();
	}

	@Override
	/** Entity 정보로 포인트 거래내역 조회 */
	public List<PointAccount> read(Long Num) {
		
		List<PointAccount> result = bankRepository.getPointAccount(Num);
		
		return result;
	}

}
