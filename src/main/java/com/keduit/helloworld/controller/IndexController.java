package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.MemberService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class IndexController {
	
	@Autowired
	private MemberService memberService;

    @GetMapping("/main")
    public void index(){
        log.info("IndexController index");
    }
    
    @GetMapping("/index")
    public void indexpage(){
    	
    }
    
    @PostMapping("/index")
    public String indexpage2() {
    	
    	return "redirect:/hello/index";
    }
    
    @GetMapping("/login")
    public void loginpage(String err, String logout) {
    }
    
    @PostMapping("/login")
    public String loginpage2(String err, RedirectAttributes direct) {

    	direct.addFlashAttribute("user", err);
    	
    	return "redirect:/hello/index";
    }
    
    @GetMapping("/register")
    public void register() {
    	    	
    }
    
    @PostMapping("/register")
    public String register(MemberDTO memberDTO) {
    	
    	memberService.register(memberDTO);
    	
    	return "redirect:/hello/index";
    }
    
  
}
