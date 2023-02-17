package com.keduit.helloworld.service;

import com.keduit.helloworld.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import com.keduit.helloworld.entity.Comment;

public interface CommentService {

    Page<CommentDTO> getComments(PageRequest commentPageRequest);

	List<Comment> getCommentList(String id);

}
