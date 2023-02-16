package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.repository.CommentRepository;
import com.keduit.helloworld.service.CommentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	
	@Override
	public List<Comment> getCommentList(String id) {

		List<Comment> comments = commentRepository.getCommentById(id);
		return comments;
	}
}
