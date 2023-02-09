package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.Account;
import com.keduit.helloworld.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{

	@Query(value="select * from Bank b "
			+ "join Account a on b.account_num = a.account_num "
			+ "join Member m on a.member_buyer = m.member_num "
			+ "where m.member_num = :num ", nativeQuery = true)
	public List<Bank> getPointAccount(Integer num);
	
}
