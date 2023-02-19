package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.MemberRole;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

	private final MemberRepository repository;
	private final PasswordEncoder passwordEncoder;

	@Override
	/** 회원 정보 입력 받으면 entity에 넣음 */
	public Long register(MemberDTO dto) {
		log.info("member ServiceImpl ------------" + dto);



		dto.setPw(passwordEncoder.encode(dto.getPw()));

		Member entity = memberDtoToMemberEntity(dto);

		entity.addMemberRole(MemberRole.USER);
		repository.save(entity);
		return entity.getMemberNum();
	}

	@Override
	/** memberNum 하나로 member하나만 불러오기*/
	public MemberDTO read(Long memberNum) {

		Optional<Member> result = repository.findById(memberNum);

		return result.isPresent()?memberEntityToMemberDto(result.get()):null;
	}

	@Override
	/** 맴버pk값을 받아서 삭제하기*/
	public void remove(Long memberNum) {
		repository.deleteById(memberNum);
		
	}

	/** 회원정보 받아서 수정 */
	@Transactional
	@Override
	public void modify(MemberDTO dto) {

		Member member = repository.getById(dto.getMemberNum());
		

		if(member != null) {
			member.change(dto.getMemberNum(), dto.getId(),passwordEncoder.encode(dto.getPw()), dto.getName()
					, dto.getNickname(), dto.getIntroduce(), dto.getEmail(), dto.getUpdateDate());

		}

		repository.save(member);
	}

	@Override
	public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 승민 시작
	@Override
	public Page<MemberDTO> getMembers(Pageable pageable) {
		return repository.findAll(pageable).map(member -> memberEntityToMemberDto(member));
	}

	@Override
	public Page<MemberDTO> getKeywordMembers(String select,String keyword, Pageable pageable) {

		Page<MemberDTO> list = null;

		if(select.equals("member_num")){
			Optional<Member> result = repository.findById(Long.parseLong(keyword));
			if(result.isPresent()){
				MemberDTO memberDTO = memberEntityToMemberDto(result.get());
				list = new PageImpl<>(Collections.singletonList(memberDTO));
			}
		}else if(select.equals("nickname")){
			list = repository.findByNickname(keyword, pageable).map(member -> memberEntityToMemberDto(member));
		}

		return list;
	}
	//승민 끝

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

	@Override
	/**id를 가지고 전체 읽어오기*/
	public Member idRead(String id) {
		Optional<Member> member = repository.getMemberId(id);

		return member.get();
	}

	@Override
	public List<Member> getMemberMarker(Long memberNum) {
		List<Member> members = repository.getMemberMarker(memberNum);

		return members;
	}

	@Override
	public List<Member> getMemberMarked(Long memberNum) {
		List<Member> members = repository.getMemberMarked(memberNum);

		return members;
	}

	//호성 02.17
	
	@Override
	public List<Member> memberAll() {
		List<Member> members = repository.findAll();
		
		return members;
	}

	//end 호성 
}
