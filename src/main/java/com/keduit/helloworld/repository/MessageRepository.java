package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

//쪽지 내역 조회	
	@Query(value = "select * from message ms "
			+ "join member m on ms.member_give = m.member_num "
			+ "where ms.member_get = :num", nativeQuery = true)
	/** 받은 쪽지 내역 조회(read, 받은사람 기준) */
	List<Message> getMsgListAsGetter(Long num);

	@Query(value = "select * from message ms "
			+ "join member m on ms.member_get = m.member_num "
			+ "where ms.member_give = :num", nativeQuery = true)
	/** 보낸 쪽지 내역 조회(read, 보낸사람 기준) */
	List<Message> getMsgListAsGiver(Long num);

//쪽지 상세 조회	
//	@Query(value = "select * from message where message_num = :num", nativeQuery = true)
//	/** 쪽지 상세 조회(read) */
//	String getMessageNum(Long num);	
	
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
