package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.BoardService;
import com.keduit.helloworld.service.CommentService;
import com.keduit.helloworld.service.MemberService;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class ModalController {

	private final MemberService memberService;
	
//    @GetMapping("/log-in")
//    public String login(){
//
//    	return "/modal/log-in";
//    }
//    @GetMapping("/sign-up")
//    public void signup(){
//
//    }
//    @GetMapping("/follower")
//    public void follower(){
//
//    }
//
//    @GetMapping("/following")
//    public void following(){
//
//    }
//    @GetMapping("/pointmodal")
//    public void pointmodal(){
//
//    }
}
