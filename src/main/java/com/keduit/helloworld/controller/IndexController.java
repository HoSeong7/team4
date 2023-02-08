package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/index/*")
public class IndexController {

    @GetMapping("/main")
    public void main(){
        log.info("IndexController main");
    }
    
    @GetMapping("/index")
    public void indexpage(){
    	
    }
}
