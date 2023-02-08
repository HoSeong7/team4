package com.keduit.helloworld.controller;

import com.keduit.helloworld.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/chat/*")
@RequiredArgsConstructor
public class RoomController {

    private final ChatRoomRepository repository;

    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){
        log.info("RoomController rooms");
        ModelAndView mav = new ModelAndView("chat/rooms");

        mav.addObject("list",repository.findAllRooms());

        return mav;
    }

    @PostMapping(value = "/rooms")
    public String createRoom(@RequestParam String name, RedirectAttributes rttr){

        log.info("RoomController createRoom");
        rttr.addFlashAttribute("roomName",repository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";
    }

    @GetMapping(value = "/room")
    public void getRoom(String roomId, Model model){
        log.info("RoomController getRoom : "+roomId);
        model.addAttribute("room", repository.findRoomById(roomId));
    }
}
