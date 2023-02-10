package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.Favorites;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.MemberAccount;

public interface MemberRepository extends JpaRepository<Member, Long>{

//	/**맴버 PK하나로 하나 불러오기*/
//	@Query(value = "select * from member where member_num= :num order by member_num", nativeQuery = true)
//	String getMemberNum(Long num);
	
	@Query(value = "select * from Favorites as f join Member m on member_num = f.bookmarked " 
			+ "where f.bookmarker= :bookmarker order by favorites_num desc", nativeQuery = true)
	/** 즐겨찾기에서 마커를 넣으면 맴버 아이디가 출력됨(즐겨찾기 한 사람들) */
	List<Member> getMemberMarker(Long bookmarker);
	
	
	@Query(value = "select * from member m "
			+ "join member_account ma on ma.member_seller = m.member_num " 
			+ "where ma.member_buyer = :num", nativeQuery = true)
	/** 회원간 거래내역 리스트 조회(read, 구매자=질문자 기준) */
	List<Member> getMemNum(Long num);
	
	
}
