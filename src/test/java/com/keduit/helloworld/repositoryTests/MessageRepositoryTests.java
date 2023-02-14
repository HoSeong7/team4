package com.keduit.helloworld.repositoryTests;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.Message;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.repository.MessageRepository;

@SpringBootTest
public class MessageRepositoryTests {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	/** 쪽지 등록 테스트(create) */
	public void insertMsgTest() {
		
		IntStream.rangeClosed(1, 5).forEach(i -> {
			
			Long a = (long)(Math.random()*10)+1;
			Long b = (long)(Math.random()*10)+1;
			
			Message entity = Message.builder()
					.memberGet(a)
					.memberGive(b)
					.title("쪽지 제목" + i)
					.content("쪽지 내용" + i)
					.view(3L)
					.build();
			messageRepository.save(entity);
		});
	}
	
//	@Test
//	/** 받은 쪽지 내역 조회(read, 받은사람 기준) */
//	public void selectMsgListAsGetter() {
//		long getMemNum = 1;
//		
//		List<Message> result1 = messageRepository.getMsgListAsGetter(getMemNum);
//		List<Member> result2 = memberRepository.getMemNumAsGetter(getMemNum);
//		
//		for(int i = 0; i <= result1.size()-1; i++) {
//			System.out.println(result1.get(i).getRegDate() + ", " + 
//								result1.get(i).getTitle() + ", " + 
//								result2.get(i).getId() //쪽지 보낸사람 아이디(memberGive)
//								);		
//		}
//	}
	
//	@Test
//	/** 보낸 쪽지 내역 조회(read, 보낸사람 기준) */
//	public void selectMsgListAsGiver() {
//		long giverMemNum = 1;
//		
//		List<Message> result1 = messageRepository.getMsgListAsGiver(giverMemNum);
//		List<Member> result2 = memberRepository.getMemNumAsGiver(giverMemNum);
//		
//		for(int i = 0; i <= result1.size()-1; i++) {
//			System.out.println(
//					"보낸 날짜 : " + result1.get(i).getRegDate() + ", " +
//					"보낸 사람 : " + result1.get(i).getMemberGive() + ", " + 
//					"받는 사람 : " + result2.get(i).getMemberNum() //쪽지 받는사람 아이디(memberGet)
//					);		
//		}
//	}
	
	@Test
	/** 받은 쪽지 내역 조회(read, 받은사람 기준, 권한 0,1만 출력) */
	public void getMsgListAsGetter() {
		List<Message> list = messageRepository.getMsgListAsGetter(7L);
		
		for (Message msg : list) {
		System.out.println("보낸 날짜 : " + msg.getRegDate() + ", " +
						   "보낸 사람 : " + msg.getMemberGive() + ", " + 
						   "받는 사람 : " + msg.getMemberGet());
		}
	}
	
	
	@Test
	/** 보낸 쪽지 내역 조회(read, 보낸사람 기준, 권한 0,2만 출력) */
	public void selectMsgListAsGiver() {
		List<Message> list = messageRepository.getMsgListAsGiver(1L);
		
		for (Message msg : list) {
		System.out.println("보낸 날짜 : " + msg.getRegDate() + ", " +
						   "보낸 사람 : " + msg.getMemberGive() + ", " + 
						   "받는 사람 : " + msg.getMemberGet());
		}
	}
	
	@Test
	/** 쪽지 상세 조회(read) */
	public void selectMsgTest() {
		Optional<Message> result = messageRepository.findById(1L);
		System.out.println(result);
	}
	
	@Test
	/** 쪽지 삭제(delete) */
	public void deleteMsgTest() {
		messageRepository.deleteById(2L);
	}
	
//	@Test
//	public void qwe() {
//		List<Message> wer = messageRepository.getMsgListAsGiver2(1L);
//		for (Message message : wer) {
//			System.out.println(message);
//		}
		
	}
	

