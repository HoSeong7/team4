package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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
}
