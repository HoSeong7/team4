package com.keduit.helloworld.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
//호성
	
//	/**맴버 PK하나로 하나 불러오기*/
//	@Query(value = "select * from member where member_num= :num order by member_num", nativeQuery = true)
//	String getMemberNum(Long num);
	
	@Query(value = "select * from Favorites as f join Member m on member_num = f.bookmarked " 
			+ "where f.bookmarker= :bookmarker order by favorites_num desc", nativeQuery = true)
	/** 즐겨찾기에서 마커를 넣으면 맴버 아이디가 출력됨(즐겨찾기 한 사람들) */
	List<Member> getMemberMarker(Long bookmarker);
	
	/**나를 즐겨찾기한 사람들 리스트*/
	@Query(value = "select * from Favorites as f join Member m on member_num = f.bookmarker "
			+ "where f.bookmarked= :bookmarked order by favorites_num desc" , nativeQuery=true)
	List<Member> getMemberMarked(Long bookmarked);

//	@EntityGraph(attributePaths = {"roleset"},type = EntityGraph.EntityGraphType.LOAD)
//	@Query(value = "select * from Member m inner join member_roleset mr on m.member_num = mr.member_member_num where m.email = :email", nativeQuery=true)
//	Optional<Member> findByEmail(String email);
//
//	@EntityGraph(attributePaths = {"roleset"},type = EntityGraph.EntityGraphType.LOAD)
//	@Query(value = "select * from Member m where m.id = :id", nativeQuery= true)
//	Optional<Member> findByidpage(String id);

	/** 로그인 처리 쿼리문 */
	 @EntityGraph(attributePaths = {"roleset"},type = EntityGraph.EntityGraphType.LOAD)
	   @Query("select m from Member m where m.purview = :social and m.id = :email")
	   Optional<Member> findByEmail(String email, Boolean social);

	 /** 맴버 아이디로 정보 뽑아오기*/
	 @Query(value="select * from member m "
	 		+ "where m.id = :id ",nativeQuery=true)
	 Optional<Member> getMemberId(String id);
	
	
	
//효영	
	 
	//회원간 거래내역	
	@Query(value = "select * from member m "
			+ "join member_account ma on ma.member_seller = m.member_num " 
			+ "where ma.member_buyer = :num", nativeQuery = true)
	/** 회원간 거래내역 리스트 조회(read, 구매자=질문자 기준) */
	List<Member> getMemNumAsBuyer(Long num);
	
	@Query(value = "select * from member m "
			+ "join member_account ma on ma.member_buyer = m.member_num " 
			+ "where ma.member_seller = :num", nativeQuery = true)
	/** 회원간 거래내역 리스트 조회(read, 판매자=답변자 기준) */
	List<Member> getMemNumAsSeller(Long num);

	//쪽지 내역 조회	
//	@Query(value = "select * from member m "
//			+ "join message ms on ms.member_give = m.member_num "
//			+ "where ms.member_get = :num", nativeQuery = true)
//	/** 받은 쪽지 내역 조회(read, 받은사람 기준) */
//	List<Member> getMemNumAsGetter(Long num);
//
//	@Query(value = "select * from member m "
//			+ "join message ms on ms.member_get = m.member_num "
//			+ "where ms.member_give = :num", nativeQuery = true)
//	/** 보낸 쪽지 내역 조회(read, 보낸사람 기준) */
//	List<Member> getMemNumAsGiver(Long num);
	
	//쪽지 삭제
//	@Query(value = "select * from member m "
//			+ "join message ms on ms.member_give = m.member_num "
//			+ "where ms.member_get = :num", nativeQuery = true)
//	/** 쪽지 삭제(delete, 받은사람 기준) */
//	List<Member> getMemNumForDeleteAsGetter(Long num);
//
//	@Query(value = "select * from member m "
//			+ "join message ms on ms.member_get = m.member_num "
//			+ "where ms.member_give = :num", nativeQuery = true)
//	/** 쪽지 삭제(delete, 보낸사람 기준) */
//	List<Member> getMemNumForDeleteAsGiver(Long num);	
	
	 /** 쪽지 보낸사람 회원번호로, 받는사람 정보 가져오기(read, 보낸사람 기준) */
	 @Query(value = "select * from member m "
	 				+ "join message ms on ms.member_get = m.member_num "
	 				+ "where ms.member_give = :num ", nativeQuery = true )
	List<Member> getMsgByMemId(Long num);
	 
	 
	 
//성진

	@Query(value = 
			"select * from Member m join Board b on m.member_num = b.member_num "
					+ " left outer join Comment c on c.board_num = b.board_num "
					+ " where b.board_num = :boardNum"
			, nativeQuery = true)
		Member getBoardByBno(Long boardNum); 

	@Query(value =
			"select * from Member m join Comment c on m.member_num = c.commenter_num "
					+ " where m.member_num = :commenterNum"
			, nativeQuery = true)
		Member getCommenter(Long commenterNum);

}
