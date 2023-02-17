package com.keduit.helloworld.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MessageService {

    Page<MessageDTO> getMessages(PageRequest messagePageRequest);
	/** 쪽지 등록(create) */
	Long register(MessageDTO dto);

	/** 받은 쪽지 리스트 조회(read, 받은사람 기준, 권한 0 or 1만 출력) */
	List<Message> getListAsGetter(Long memberGet);

	/** 보낸 쪽지 리스트 조회(read, 보낸사람 기준, 권한 0 or 2만 출력) */
	List<Message> getListAsGiver(Long memberGive);

	/** 쪽지 상세 조회(read) */
	MessageDTO read(Long messageNum);

	/** 받은 사람이 쪽지 삭제 시 보기권한 변경(update, 보기권한 +2) */
	void modifyViewAsGetter(MessageDTO dto);

	/** 보낸 사람이 쪽지 삭제 시 보기권한 변경(update, 보기권한 +1) */
	void modifyViewAsGiver(MessageDTO dto);

//	/** 쪽지 삭제(delete, 보기권한 3일때) */
//	void remove(Long messageNum);

	/** DTO에 있는 정보를 Entity로 옮기기 */
	default Message MessageDtoToEntity(MessageDTO dto) {

		Message entity = Message.builder()
				.messageNum(dto.getMessageNum())
				.memberGet(dto.getMemberGet())
				.memberGive(dto.getMemberGive())
				.title(dto.getTitle())
				.content(dto.getContent())
				.view(dto.getView())
				.url(dto.getUrl())
				.build();
		return entity;
	}

	/** Entity에 있는 정보를 DTO로 옮기기 */
	default MessageDTO MessageEntityToDto(Message entity) {

		MessageDTO dto = MessageDTO.builder()
				.messageNum(entity.getMessageNum())
				.memberGet(entity.getMemberGet())
				.memberGive(entity.getMemberGive())
				.title(entity.getTitle())
				.content(entity.getContent())
				.view(entity.getView())
				.url(entity.getUrl())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}
	
	/** 쪽지 보낸사람 회원번호로, 받는사람 정보 가져오기(read, 보낸사람 기준) */
	List<Message> getMsgListAsGiver(String username);
}
