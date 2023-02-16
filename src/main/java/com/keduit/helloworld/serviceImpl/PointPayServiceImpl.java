package com.keduit.helloworld.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.PointPayService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointPayServiceImpl implements PointPayService {@Override
	public void modify(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
	}

//	private final MemberRepository memberRepository;
//	
//	@Override
//	public void modify(Long memberNum) {
//		
//		Optional<Member> result = memberRepository.findById(memberNum);
//		Member member = memberRepository.findById(memberRepository
//		
//		memberRepository.save(entity);
//		
//		
//	}
	
//	@Override
//	public void modify(MemberDTO memberDTO) {
//		
//		Member member = memberRepository.getById(memberDTO.getMemberNum());
//		memberRepository.save(member);
//		
//	}

}
