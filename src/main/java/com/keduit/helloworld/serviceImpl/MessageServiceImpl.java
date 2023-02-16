package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public Page<MessageDTO> getMessages(PageRequest messagePageRequest) {
        return null;
    }
}
