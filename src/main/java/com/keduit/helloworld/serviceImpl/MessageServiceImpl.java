package com.keduit.helloworld.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;
import com.keduit.helloworld.repository.MessageRepository;
import com.keduit.helloworld.service.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;
//	private final Message message;
	
	@Override
	/** 쪽지 등록(create) */
	public Long register(MessageDTO dto) {
		
		log.info("Message ServiceImpl register");
		
		Message entity = MessageDtoToEntity(dto);
		messageRepository.save(entity);
		
		return entity.getMessageNum();
	}
	
	@Override
	/** 쪽지 리스트 조회(read, 받은사람 기준, 권한 0 or 1만 출력) */
	public List<Message> getListAsGetter(Long memberGet) {
		
		List<Message> result = messageRepository.getMsgListAsGetter(memberGet);
		
		return result;
	}
	
	@Override
	/** 쪽지 리스트 조회(read, 보낸사람 기준, 권한 0 or 2만 출력) */
	public List<Message> getListAsGiver(Long memberGive) {
		
		List<Message> result = messageRepository.getMsgListAsGiver(memberGive);
		
		return result;
	}

	@Override
	/** 쪽지 상세 조회(read) */
	public MessageDTO read(Long messageNum) {
		
		Optional<Message> result = messageRepository.findById(messageNum);
		
		return result.isPresent()? MessageEntityToDto(result.get()) : null;
	}

	@Override
	/** 받은 사람이 쪽지 삭제 시 보기권한 변경(update, 보기권한 +2) */
	public void modifyViewAsGetter(MessageDTO dto) {
		
		Optional<Message> result = messageRepository.findById(dto.getMessageNum());
		
		if(result.isPresent()) {
			
			Message entity = result.get();
			
			entity.changes(dto.getView());
			
			messageRepository.save(entity);
		}
	}

	@Override
	/** 보낸 사람이 쪽지 삭제 시 보기권한 변경(update, 보기권한 +1) */
	public void modifyViewAsGiver(MessageDTO dto) {
		
		Optional<Message> result = messageRepository.findById(dto.getMessageNum());
		
		if(result.isPresent()) {

			Message entity = result.get();
			
			entity.changes(dto.getView());
			
			messageRepository.save(entity);
		
//		log.info("Message ServiceImpl modify");
//		Message message = messageRepository.getById(dto.getMemberGive());
//		messageRepository.save(message);
		}
	}


	
//	@Override
//	/** 쪽지 삭제(delete) */
//	public void remove(Long messageNum) {
//		messageRepository.deleteById(messageNum);
//	}

//	@Override
//	/** 쪽지 삭제(delete, 받은사람 기준) */
//	public void removeAsGetter(Long memberGet) {
//		messageRepository.deleteMsgAsGetter(memberGet);
//	}
//	
//	@Override
//	/** 쪽지 삭제(delete, 보낸사람 기준) */
//	public void removeAsGiver(Long memberGive) {
//		messageRepository.deleteMsgAsGiver(memberGive);
//	}
	
	
}
