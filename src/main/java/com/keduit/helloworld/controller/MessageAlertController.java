package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/hello/*")
public class MessageAlertController {

    @PostMapping("/memoryUserNum")
    public void memoryUserNum(@RequestParam HashMap<Object, Object> params){
        int memberGive = (int) params.get("memberGive");

    }
}
