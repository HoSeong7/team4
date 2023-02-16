package com.keduit.helloworld.service;


import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MessageService {

    Page<MessageDTO> getMessages(PageRequest messagePageRequest);
}
