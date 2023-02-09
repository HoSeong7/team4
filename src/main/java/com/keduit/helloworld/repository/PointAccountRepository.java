package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.PointAccount;

public interface PointAccountRepository extends JpaRepository<PointAccount, Long>{

	@Query(value="select * from PointAccount p "
			+ "join Member m on p.member_num = m.member_num "
			+ "where m.member_num = :num ", nativeQuery = true)
	public List<PointAccount> getPointAccount(Long num);
	
}
