package com.keduit.helloworld.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.Tetris;
import com.keduit.helloworld.service.MemberService;
import com.keduit.helloworld.service.TetrisService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/icon/*")
public class IconController {
	
	private final TetrisService tetrisService;
	private final MemberService memberService;
	
	@GetMapping("/calculator")
	public void calculator() {
		log.info("IconController calculator");
	}
	
	@GetMapping("/memo")
	public void memo() {
		log.info("IconController memo");
	}
	
	@GetMapping("/tetris")
	public void tetris(Model model) {
		log.info("IconController tetris");
		List<Tetris> max3 = tetrisService.getMax3();
		model.addAttribute("max",max3);
	}
	
	@GetMapping("/compass")
	public void compass() {
		log.info("IconController compass");
	}
	
	@GetMapping("/stopwatch")
	public void stopwatch() {
		log.info("IconController stopwatch");
	}
	
	@PostMapping("/chk/{max}")
	public ResponseEntity<List<Tetris>> chk(@PathVariable("max") Long max ,Authentication authentication){
		
		//내 아이디 가져오기
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		Member me =  memberService.idRead(userDetails.getUsername());
		tetrisService.insertNum(me.getMemberNum(), max);
		
//		System.out.println(max3);
		
		return new ResponseEntity<>(null , HttpStatus.OK);
	}

}
