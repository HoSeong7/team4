package com.keduit.helloworld.repositoryTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.repository.CommentRepository;

@SpringBootTest
public class CommentRepositoryTests {

	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	public void insertcommentTest() {
		
	}
}
