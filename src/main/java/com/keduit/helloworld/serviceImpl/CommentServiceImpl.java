package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public Page<CommentDTO> getComments(PageRequest commentPageRequest) {
        return null;
    }
}
