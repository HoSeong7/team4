package com.keduit.helloworld.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.entity.Member;

public interface MemberService {
	
	
	
	/** member 회원가입*/
	Long register(MemberDTO dto);	
	
	/** member 읽기 */
	MemberDTO read(Long memberNum);
	
	/** member 삭제 */
	void remove(Long memberNum);
	
	/** member 정보수정 */
	void modify(MemberDTO dto);
	
	/** memberEntity에 있는 정보를 memberDTO로 옮기기 */
	default MemberDTO memberEntityToMemberDto(Member entity) {
		
		MemberDTO dto = MemberDTO.builder().memberNum(entity.getMemberNum())
										   .id(entity.getId())
										   .pw(entity.getPw())
										   .name(entity.getName())
										   .point(entity.getPoint())
										   .purview(entity.getPurview())
										   .nickname(entity.getNickname())
										   .introduce(entity.getIntroduce())
										   .email(entity.getEmail())
										   .exvalue(entity.getExvalue())
										   .url(entity.getUrl())
										   .regDate(entity.getRegDate())
										   .updateDate(entity.getUpdateDate())
										   .build();
		return dto;
	}
	/** memberDTO에 있는 정보를 memberEntity로 옮기기*/
	default Member memberDtoToMemberEntity(MemberDTO dto) {
		
	
		Member entity = Member.builder().memberNum(dto.getMemberNum())
										.id(dto.getId())
										.pw(dto.getPw())
										.name(dto.getName())
										.point(dto.getPoint())
										.purview(dto.getPurview())
										.nickname(dto.getNickname())
										.introduce(dto.getIntroduce())
										.email(dto.getEmail())
										.exvalue(dto.getExvalue())
										.url(dto.getUrl())
										.build();
		
		return entity;
	}
	
	/** member 정보 검색하기 */
	BooleanBuilder getSearch(PageRequestDTO requestDTO);

//	Map<String, Object> checkLoginAvailable(Map<String, Object> param);
}
