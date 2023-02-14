package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	@Query(value = 
			"select count(board_comment_num) from Board b join Member m on m.member_num = b.member_num "
			+ " left outer join Comment c on c.board_num = b.board_num "
			+ " where b.board_num = :boardNum"
			, nativeQuery = true)
		Long getBoardByBno(Long boardNum); 
	
	@Query(value = 
			"select * from Board b join Member m on m.member_num = b.member_num "
			+ " left outer join Comment c on c.board_num = b.board_num "
			+ " where b.board_num = :boardNum"
			, nativeQuery = true)
	List<Comment> getCommentlist(Long boardNum);
	
	
}
