package com.keduit.helloworld.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.keduit.helloworld.entity.MemberAccount;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long>{

//	@Query(value = "select * from Account a "
//			+ "inner join Bank where memberBuyer = 4")
//	List<Object> list(); 
	
}
