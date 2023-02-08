package com.keduit.helloworld.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ChatMessageDTO {

    private String roomId;
    private String writer;
    private String message;
}
