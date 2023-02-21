package com.keduit.helloworld.repository;

import java.util.List;

import com.keduit.helloworld.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
			"select * from Comment c right join Board b on b.board_num = c.board_num "
			+ " join Member m on b.member_num = m.member_num "
			+ " where b.board_num = :boardNum"
			, nativeQuery = true)
	List<Comment> getCommentlist(Long boardNum);

	@Query(value = "select * from Comment c "
				 + "left outer join Board b on c.board_num = b.board_num "
				 + "left outer join member m on m.member_num = b.member_num "
				 + "where m.member_num = :id order by c.board_comment_Num desc", nativeQuery = true)
	List<Comment> getCommentById(String id);

	//승민
	@Query(value = "SELECT * FROM message WHERE commenter_num = :str1", nativeQuery = true)
	Page<Comment> findByCommenterNum(String str1, Pageable pageable);
	
	//승민 끝


}
