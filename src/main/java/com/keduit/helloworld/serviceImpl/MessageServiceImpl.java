package com.keduit.helloworld.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.Message;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.repository.MessageRepository;
import com.keduit.helloworld.service.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;
	private final MemberRepository memberRepository;

	@Override
	/** 쪽지 등록(create) */
	public Long register(MessageDTO dto, Long memberGet, Long memberGive, Long boardCommentNum) {

		log.info("Message ServiceImpl register");

		Message entity = messageDtoToEntity(dto, memberGet, memberGive,boardCommentNum);
		
		messageRepository.save(entity);

		return entity.getMessageNum();
	}
	
	@Override
	/** 쪽지 리스트 조회(read, 받은사람 기준, 권한 0 or 1만 출력) */
	public List<MessageDTO> getListAsGetter(Long memberGet) {

		List<Message> result = messageRepository.getMsgListAsGetter(memberGet);
		List<Member> mlist = memberRepository.getMemNicknameByGetter(memberGet);
		List<MessageDTO> list = new ArrayList<>();

		for (int i = 0; i < result.size(); i++) {
			MessageDTO messageDto = messageEntityToDto(result.get(i));
			messageDto.setNickname(mlist.get(i).getNickname());
			list.add(messageDto);
		}
		return list;
	}
	

	@Override
	/** 쪽지 리스트 조회(read, 보낸사람 기준, 권한 0 or 2만 출력) */
	public List<MessageDTO> getListAsGiver(Long memberGive) {

		List<Message> result = messageRepository.getMsgListAsGiver(memberGive);
		List<Member> mlist = memberRepository.getMemNicknameByGiver(memberGive);
		List<MessageDTO> list = new ArrayList<>();
		
		for (int i = 0; i < result.size(); i++) {
			MessageDTO messageDto = messageEntityToDto(result.get(i));
			messageDto.setNickname(mlist.get(i).getNickname());
			list.add(messageDto);
		}
		return list;
	}
	
	@Override
	/** 쪽지 상세 조회(read) */
	public MessageDTO read(Long messageNum) {

		Optional<Message> result = messageRepository.findById(messageNum);

		return result.isPresent()? messageEntityToDto(result.get()) : null;
	}
	
	@Override
	/** 받은 사람이 쪽지 삭제 시 보기권한 변경 & 최종 삭제(update: 보기권한 +2, delete: 권한 3일때) */
	public void modifyViewAsGetter(Long messageNum, Long view) {

		Optional<Message> result = messageRepository.findById(messageNum);

		if(result.isPresent()) {
			Message entity = result.get();
			entity.changes(view + 2); //보기권한 0은 2, 1은 3으로 변경
			
			if(entity.getView() >= 3) {
				messageRepository.deleteById(messageNum); //3이면 삭제
			}else {
				messageRepository.save(entity);
			}
		}
	}
	
	@Override
	/** 보낸 사람이 쪽지 삭제 시 보기권한 변경 & 최종 삭제(update: 보기권한 +1, delete: 권한 3일때) */
	public void modifyViewAsGiver(Long messageNum, Long view) {

		Optional<Message> result = messageRepository.findById(messageNum);

		if(result.isPresent()) {
			Message entity = result.get();
			entity.changes(view + 1); //보기권한 0은 1, 2는 3으로 변경

			if(entity.getView() >= 3) {
				messageRepository.deleteById(messageNum);
			} else {
				messageRepository.save(entity);
			}
		}
	}

    @Override
    /** 쪽지 리스트 페이징(관리자 모드) */
    public Page<MessageDTO> getMessages(PageRequest messagePageRequest) {
        return null;
    }
    
}
