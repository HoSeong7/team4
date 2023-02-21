package com.keduit.helloworld.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.repository.search.SearchBoardRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository{

	
	@Query(value = 
			"select * from Board b join Member m on m.member_num = b.member_num "
					+ " left outer join Comment c on c.board_num = b.board_num "
					+ " where b.board_num = :boardNum"
			, nativeQuery = true)
		Board getBoardByBno(Long boardNum);

	/**내가 작성한 게시판 보기*/
	@Query(value = "select * from board b "
				  + "join member m on m.member_num = b.member_num "
				  + "where m.id = :id order by b.board_num desc", nativeQuery=true)
	List<Board> getMyBoardList(String id);

	//승민

	@Query(value = "SELECT * FROM board WHERE title = :str", nativeQuery = true)
	Page<Board> findByTitle(String str, Pageable pageable);

	@Query(value = "SELECT * FROM board WHERE member_num = :str", nativeQuery = true)
	Page<Board> findByMemberNum(String str, Pageable pageable);

	//승민 끝

	@Query(value = "select * from board where :str = :num", nativeQuery = true)
    List<Board> temp(String str, Integer num);



}
