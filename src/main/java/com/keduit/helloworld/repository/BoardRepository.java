package com.keduit.helloworld.repository;

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
		Object getBoardByBno(Long boardNum); 
	
//	"select * from Board b join Member m on m.member_num = b.member_num "
//	+ " left outer join Comment c on c.board_num = b.board_num "
//	+ " where b.board_num = :boardNum"
	
	
}
