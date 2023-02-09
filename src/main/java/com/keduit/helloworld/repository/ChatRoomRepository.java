package com.keduit.helloworld.repository;

import com.keduit.helloworld.dto.ChatRoomDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoomDTO> chatRoomDTOMap;

    public ChatRoomRepository() {
        chatRoomDTOMap = Collections.unmodifiableMap(
                Stream.of(ChatRoomDTO.create("1번방"), ChatRoomDTO.create("2번방"), ChatRoomDTO.create("3번방"))
                        .collect(Collectors.toMap(ChatRoomDTO::getRoomId, Function.identity())));

        chatRooms = Collections.unmodifiableCollection(chatRoomDTOMap.values());
    }

    public List<ChatRoomDTO> findAllRooms(){
        List<ChatRoomDTO> list = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(list);
        return list;
    }

    public ChatRoomDTO findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    public ChatRoomDTO createChatRoomDTO(String name){
        ChatRoomDTO room = ChatRoomDTO.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);
        return room;
    }

}
