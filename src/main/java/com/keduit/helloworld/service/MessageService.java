package com.keduit.helloworld.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MessageService {

	//승민
	/** 관리자용 쪽지 페이징 처리 */
	Page<MessageDTO> getMessages(Pageable pageable);
	Page<MessageDTO> getKeywordMessages(String select,String keyword,Pageable pageable);

	//승민 끝

	/** 쪽지 등록(create) */
	Long register(MessageDTO dto, Long memberGet, Long memberGive, Long boardCommentNum);

	/** 받은 쪽지 리스트 조회(read, 받은사람 기준, 권한 0 or 1만 출력) */
	List<MessageDTO> getListAsGetter(Long memberGet);

	/** 보낸 쪽지 리스트 조회(read, 보낸사람 기준, 권한 0 or 2만 출력) */
	List<MessageDTO> getListAsGiver(Long memberGive);

	/** 쪽지 상세 조회(read) */
	MessageDTO read(Long messageNum);

	/** 받은 사람이 쪽지 삭제 시 보기권한 변경 & 최종 삭제(update: 보기권한 +2, delete: 권한 3일때) */
	void modifyViewAsGetter(Long messageNum, Long view); //

	/** 보낸 사람이 쪽지 삭제 시 보기권한 변경 & 최종 삭제(update: 보기권한 +1, delete: 권한 3일때) */
	void modifyViewAsGiver(Long messageNum, Long view);

	/** DTO에 있는 정보를 Entity로 옮기기 */
	default Message messageDtoToEntity(MessageDTO dto, Long memberGet, Long memberGive, Long boardCommentNum) {

		Message entity = Message.builder()
				.messageNum(dto.getMessageNum())
				.memberGet(memberGet)
				.memberGive(memberGive)
				.boardCommentNum(boardCommentNum)
				.title(dto.getTitle())
				.content(dto.getContent())
				.view(dto.getView())
				.url(dto.getUrl())
				.build();
		return entity;
	}

	/** Entity에 있는 정보를 DTO로 옮기기 */
	default MessageDTO messageEntityToDto(Message entity) {

		MessageDTO dto = MessageDTO.builder()
				.messageNum(entity.getMessageNum())
				.memberGet(entity.getMemberGet())
				.memberGive(entity.getMemberGive())
				.boardCommentNum(entity.getBoardCommentNum())
				.title(entity.getTitle())
				.content(entity.getContent())
				.view(entity.getView())
				.url(entity.getUrl())
				.regDate(entity.getRegDate())
				.updateDate(entity.getUpdateDate())
				.build();
		return dto;
	}

}
