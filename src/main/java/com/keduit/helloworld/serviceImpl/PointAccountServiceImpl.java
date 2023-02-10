package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.PointAccountRepository;
<<<<<<< HEAD
import com.keduit.helloworld.service.PointAccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointAccountServiceImpl implements PointAccountService {

	private final PointAccountRepository repository;
	
	@Override
	/** DTO에서 Entity로 포인트 정보 등록 */
	public Long register(PointAccountDTO dto) {
		log.info("PointAccount ServiceImpl ---------- : " + dto);
		
		PointAccount entity = pointAccountDtoToEntity(dto);
		log.info("PointAccount DTO 에서 Entity로 값 넣기 : " + entity);
		
		repository.save(entity);
		return entity.getMemberNum();
	}

	@Override
	public List<PointAccount> read(Long bankNum) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	/** Entity 정보로 포인트 거래내역 조회 */
//	public List<PointAccount> read(Long memberNum) {
//		
//		List<PointAccount> result = repository.getPointAccount(memberNum);
//		
//		return result;
//	}
=======
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
>>>>>>> branch 'HW_HS' of https://github.com/HoSeong7/team4.git

}
