package com.keduit.helloworld.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class ChatRoomDTO {

    private String roomId;
    private String roomName;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomDTO create(@NonNull String roomName){
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.roomName = roomName;
        return room;
    }
}
