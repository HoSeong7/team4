package com.keduit.helloworld.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

//쪽지 내역 조회	
	@Query(value = "select * from message ms "
			+ "join member m on ms.member_give = m.member_num "
			+ "where ms.member_get = :memGetNum "
			+ "and view in (0, 1) order by ms.regdate desc", nativeQuery = true)
	/** 받은 쪽지 리스트 조회(read, 받은사람 기준, 권한 0 or 1만 출력) */
	List<Message> getMsgListAsGetter(Long memGetNum);
	
	@Query(value = "select * from message ms "
			+ "join member m on ms.member_get = m.member_num "
			+ "where ms.member_give = :memGiveNum "
			+ "and view in (0, 2) order by ms.regdate desc", nativeQuery = true)
	/** 보낸 쪽지 리스트 조회(read, 보낸사람 기준, 권한 0 or 2만 출력) */
	List<Message> getMsgListAsGiver(Long memGiveNum);
	

//쪽지 상세 조회	
//	@Query(value = "select * from message where message_num = :num", nativeQuery = true)
//	/** 쪽지 상세 조회(read) */
//	String getMessageNum(Long num);	
	
//쪽지 삭제
	@Query(value = "delete from message where view = :viewNum", nativeQuery = true)
	/** 쪽지 삭제(delete, 보기권한 3일때) */
	void deleteMsgWhenView3(Long viewNum);

	//쪽지 삭제
//	@Query(value = "delete from message ms "
//			+ "join member m on ms.member_give = m.member_num "
//			+ "where ms.member_get = :num", nativeQuery = true)
//	/** 쪽지 삭제(delete, 받은사람 기준) */
//	void deleteMsgAsGetter(Long num);
//	
//	@Query(value = "delete from message ms "
//			+ "join member m on ms.member_get = m.member_num "
//			+ "where ms.member_give = :num", nativeQuery = true)
//	/** 쪽지 삭제(delete, 보낸사람 기준) */
//	void deleteMsgAsGiver(Long num);

}
