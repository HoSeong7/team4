package com.keduit.helloworld.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.PointPayService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PointPayServiceImpl implements PointPayService {
	
	private final MemberRepository memberRepository;
	
	@Override
	public void modify(Long memberNum, Long payment) {
		Optional<Member> result = memberRepository.findById(memberNum); 
		
		if(result.isPresent()) {
			Long memberPoint = result.get().getPoint(); 
			
			Member member = result.get(); //멤버 정보 가져온 것 넣어줌
			
			member = Member.builder()
					.memberNum(memberNum)
					.point(memberPoint + payment) //포인트 수정 
					.build();
			
			memberRepository.save(member);
		}
	}


}
