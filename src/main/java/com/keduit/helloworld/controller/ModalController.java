package com.keduit.helloworld.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/modal/*")
public class ModalController {

    @GetMapping("/log-in")
    public String login(){

    	return "/modal/log-in";
    }
    @GetMapping("/sign-up")
    public void signup(){

    }
    @GetMapping("/follower")
    public void follower(){

    }

    @GetMapping("/following")
    public void following(){

    }
    @GetMapping("/pointmodal")
    public void pointmodal(){

    }
}
