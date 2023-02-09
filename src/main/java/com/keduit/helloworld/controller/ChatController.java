package com.keduit.helloworld.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@Profile("stomp")
public class ChatController {

  
}
