package com.keduit.helloworld.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.MemberAccount;


@Repository
=======

import org.springframework.data.jpa.repository.JpaRepository;

import com.keduit.helloworld.entity.MemberAccount;

>>>>>>> branch 'HW_HS' of https://github.com/HoSeong7/team4.git
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long>{

//	@Query(value = "select * from Account a "
//			+ "inner join Bank where memberBuyer = 4")
//	List<Object> list(); 
	
}
