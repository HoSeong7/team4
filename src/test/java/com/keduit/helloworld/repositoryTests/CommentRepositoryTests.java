package com.keduit.helloworld.repositoryTests;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.repository.CommentRepository;

@SpringBootTest
public class CommentRepositoryTests {

	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	public void insertcommentTest() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Comment comment = Comment.builder().boardNum((long)(Math.random()*10)+40)
												.commentContent(i + "번째 내용")
												.viewpicture(i+"번사진.jpg")
												.price((long)i * 1000)
												.clikes((long)i*50)
												.build();
			commentRepository.save(comment);
		});
	}
}
