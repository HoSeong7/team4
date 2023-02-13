package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
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
	
	
	

}
