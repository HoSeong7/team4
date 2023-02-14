package com.keduit.helloworld.repositoryTests;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.repository.BoardRepository;
import com.keduit.helloworld.repository.CommentRepository;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class CommentRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private MemberRepository memberRepository;
	
	
	@Test
	/** 더미 Test */
	public void insertReply() {
		
		IntStream.rangeClosed(1, 600).forEach(i -> {
			long boardNum = (long)(Math.random() * 305) + 1;
			
			Comment comment = Comment.builder()
					.boardNum(boardNum)
					.commenterNum((long) (Math.random()*30))
					.commentContent("뎃글 " + i + " 번 내용입니다.")
					.build();
			commentRepository.save(comment);
		});
	}
	
	
	
}
