package com.keduit.helloworld.controller;

import com.keduit.helloworld.dto.ChatRoomDTO;
import com.keduit.helloworld.repository.ChatRoomRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@Profile("stomp")
public class ChatController {

    private final ChatRoomRepository repository;
    private final AtomicInteger seq = new AtomicInteger(0);

    public ChatController(ChatRoomRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/rooms")
//    public String rooms(Model model) {
//        model.addAttribute("rooms", repository.getChatRooms());
//        return "/chat/room-list";
//    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model) {
        ChatRoomDTO room = repository.findRoomById(id);
        model.addAttribute("room", room);
        model.addAttribute("member", "member" + seq.incrementAndGet()); // 회원 이름 부여

        return "/chat/room";
    }
}
