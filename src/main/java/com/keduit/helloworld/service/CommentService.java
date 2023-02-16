package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.entity.Comment;

public interface CommentService {

	List<Comment> getCommentList(String id);
    
}
