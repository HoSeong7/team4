package com.keduit.helloworld.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MemberService {
	


	/** member 회원가입*/
	Long register(MemberDTO dto);	
	
	/** member 읽기 */
	MemberDTO read(Long memberNum);
	
	/** id로 전체 읽기*/
	Member idRead(String id);

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


	Page<MemberDTO> getMembers(PageRequest memberPageRequest);

	/** 내가 팔로한 사람들 */
	List<Member> getMemberMarker(Long memberNum);

	/** 나를 팔로한 사람들 */
	List<Member> getMemberMarked(Long memberNum);

	//호성  02.18

	/** 아이디 중복 체크 
	 * @param id */
	Integer memberCount(String id);

	/** 닉네임 중복체크 */
	Integer membernickCount(String nickname);

	
	//end 호성
	
//	Map<String, Object> checkLoginAvailable(Map<String, Object> param);
}
