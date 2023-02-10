package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.PointAccount;

public interface PointAccountRepository extends JpaRepository<PointAccount,Long>{

	@Query(value="select * from Point_Account b "
			+ "join Member m on b.member_num = m.member_num "
			+ "where b.member_num = :num ", nativeQuery = true)
	public List<PointAccount> getPointAccount(Long num);
	
	@Query(value="select * from Point_Account b "
			+ "join Member m on b.member_num = m.member_num "
			+ "where b.member_num = :num ", nativeQuery = true)
	public List<Member> getPointAccount2(Long num);
}
