package com.keduit.helloworld.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.PointAccount;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.repository.PointAccountRepository;
import com.keduit.helloworld.service.PointAccountService;
import com.keduit.helloworld.service.PointPayService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointAccountServiceImpl implements PointAccountService {

	private final PointAccountRepository pointAccountRepository;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	/** (DTO에서 Entity로) 포인트 거래내역 등록(create) */
	public Long register(PointAccountDTO dto) {

		log.info("PointAccount ServiceImpl ---------- : " + dto);

		PointAccount entity = pointAccountDtoToEntity(dto);
		log.info("PointAccount DTO 에서 Entity로 값 넣기 : " + entity);

		pointAccountRepository.save(entity);

		return entity.getMemberNum();
	}

	@Override
	/** (Entity 정보로) 포인트 거래내역 리스트 조회(read) */
	public List<PointAccountDTO> read(Long num) {

		List<PointAccount> result = pointAccountRepository.getPointAccount(num);
		List<PointAccountDTO> list = new ArrayList<>();

		for (PointAccount pa : result) {
			PointAccountDTO pointAccountDTO = pointAccountEntityToDto(pa);
			list.add(pointAccountDTO);
		}
		return list;
	}

	// 호성 23.02.21

	@Override
	public Long setCharge(Long id, Long point, Long charge, MemberDTO memdto) {
		PointAccountDTO dto = PointAccountDTO.builder().memberNum(id).charge(charge).balance(point + (charge * 100))// 100배
				.build();
		PointAccount entity = pointAccountDtoToEntity(dto);
		memdto.setMemberNum(id);
		memdto.setPoint(point + (charge*100));
		Member member = memberDtoToMemberEntity(memdto);
				
		memberRepository.save(member);
		pointAccountRepository.save(entity);
		
		return entity.getMemberNum();
	}

	@Override
	public Long setExCharge(Long id, Long point, Long excharge, MemberDTO memdto) {
		PointAccountDTO dto = PointAccountDTO.builder().memberNum(id).exchange(excharge).balance(point - (excharge * 100))// 100배
				.build();
		PointAccount entity = pointAccountDtoToEntity(dto);
		memdto.setMemberNum(id);
		memdto.setPoint(point - (excharge*100));
		Member member = memberDtoToMemberEntity(memdto);
		memberRepository.save(member);
		pointAccountRepository.save(entity);

		return entity.getMemberNum();
	}

	// 호성 end
}
