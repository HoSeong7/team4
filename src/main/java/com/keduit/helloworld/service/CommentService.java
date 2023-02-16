package com.keduit.helloworld.service;

import com.keduit.helloworld.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CommentService {

    Page<CommentDTO> getComments(PageRequest commentPageRequest);
}
