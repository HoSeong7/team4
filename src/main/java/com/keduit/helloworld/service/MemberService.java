package com.keduit.helloworld.service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.entity.Member;

public interface MemberService {
	
	/** member 회원가입*/
	Integer register(MemberDTO dto);	
	
	/** member 읽기 */
	MemberDTO read(Integer memberNum);
	
	/** member 삭제 */
	void remove(Integer memberNum);
	
	/** member 정보수정 */
	void modify(MemberDTO dto);
	
	/** memberEntity에 있는 정보를 memberDTO로 옮기기 */
	default MemberDTO memberEntityToMemberDto(Member entity) {
		
		MemberDTO dto = MemberDTO.builder().memberNum(entity.getMemberNum())
										   .id(entity.getId())
										   .pw(entity.getPw())
										   .memberName(entity.getMemberName())
										   .point(entity.getPoint())
										   .purview(entity.getPurview())
										   .nickName(entity.getNickname())
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
										.memberName(dto.getMemberName())
										.point(dto.getPoint())
										.purview(dto.getPurview())
										.nickname(dto.getNickName())
										.introduce(dto.getIntroduce())
										.email(dto.getEmail())
										.exvalue(dto.getExvalue())
										.url(dto.getUrl())
										.build();
		
		return entity;
	}
	
	/** member 정보 검색하기 */
	BooleanBuilder getSearch(PageRequestDTO requestDTO);
}
