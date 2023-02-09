package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.MemberAccount;


@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long>{

//	@Query(value = "select * from Account a "
//			+ "inner join Bank where memberBuyer = 4")
//	List<Object> list(); 
	
}
