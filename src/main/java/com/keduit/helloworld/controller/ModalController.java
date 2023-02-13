package com.keduit.helloworld.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/modal/*")
public class ModalController {

    @GetMapping("/log-in")
    public void login(){

    }
    @GetMapping("/sign-up")
    public void signup(){

    }
}
