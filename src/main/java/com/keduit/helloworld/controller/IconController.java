package com.keduit.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/icon/*")
public class IconController {
	
	@GetMapping("/calculator")
	public void calculator() {
		log.info("IconController calculator");
	}
	
	@GetMapping("/memo")
	public void memo() {
		log.info("IconController memo");
	}
	
	@GetMapping("/tetris")
	public void tetris() {
		log.info("IconController tetris");
	}
	
	@GetMapping("/compass")
	public void compass() {
		log.info("IconController compass");
	}
	
	@GetMapping("/stopwatch")
	public void stopwatch() {
		log.info("IconController stopwatch");
	}

}
