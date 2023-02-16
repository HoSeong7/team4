package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//	@Modifying
//	@Query("delete from Reply r where r.board.bno = :bno")
//	void deleteByBno(Long bno);
//	
//	
//	// 게시물로 댓글 가져오기
//	
//	List<Comment> getRepliesByBoardOrderByRno(Board board);
//	
	
	@Query(value = 
//			"select count(board_comment_num) from comment  where board_num = :boardNum;"
			"select count(board_comment_num) from Board b join Member m on m.member_num = b.member_num "
			+ " left outer join Comment c on c.board_num = b.board_num "
			+ " where b.board_num = :boardNum"
			, nativeQuery = true)
		Long getBoardByBno(Long boardNum);

	@Query(value = "select * from Comment c "
				 + "left outer join Board b on c.board_num = b.board_num "
				 + "left outer join member m on m.member_num = b.member_num "
				 + "where m.member_num = :id order by c.board_comment_Num desc", nativeQuery = true)
	List<Comment> getCommentById(String id); 
	
	
}
