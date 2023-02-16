package com.keduit.helloworld.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {
	@Override
	public Long register(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO read(Long memberNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long memberNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MemberDTO> getMembers(PageRequest memberPageRequest) {
		return null;
	}
//
//	private final MemberRepository repository;
//	
//	@Override
//	/** 회원 정보 입력 받으면 entity에 넣음 */
//	public Long register(MemberDTO dto) {
//		log.info("member ServiceImpl ------------" + dto);
//		
//		Member entity = memberDtoToMemberEntity(dto);
//		log.info("member DTO 에서 Entity로 값 넣기 " + entity);
//		
//		repository.save(entity);
//		return entity.getMemberNum();
//	}
//
//	@Override
//	/** memberNum 하나로 member하나만 불러오기*/
//	public MemberDTO read(Long memberNum) {
//		
//		Optional<Member> result = repository.findById(memberNum);
//		
//		return result.isPresent()?memberEntityToMemberDto(result.get()):null;
//	}
//
//	@Override
//	/** 맴버pk값을 받아서 삭제하기*/
//	public void remove(Long memberNum) {
//		repository.deleteById(memberNum);
//		
//	}
//
//	@Override
//	/** 회원정보 받아서 수정 */
//	public void modify(MemberDTO dto) {
//
//		Member member = repository.getById(dto.getMemberNum());
//		
//		repository.save(member);
//	}
//
//	@Override
//	public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
