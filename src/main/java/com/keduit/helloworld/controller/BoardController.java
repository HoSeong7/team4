package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    @GetMapping("/board")
    public void ex(){
        log.info("BoardController ex");
    }

}
