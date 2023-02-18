package com.keduit.helloworld.controller;

import java.util.HashMap;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.MemberService;
import com.keduit.helloworld.service.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class MessageController {

	private final MessageService messageService;
	private final MemberService memberService;

	@GetMapping("/message")
	public void message(Authentication authentication, Model model) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		/** 쪽지 보낸사람 회원번호로, 받는사람 회원정보 가져오기(read, 보낸사람 기준) */ 
		MemberDTO memberDTO = memberService.getMemNum(userDetails.getUsername());
		
		/** 쪽지 보낸사람 회원번호로, 받은사람 리스트 가져오기(read, 보낸사람 기준) */ 
		List<MessageDTO> messageGive = messageService.getListAsGiver(memberDTO.getMemberNum()); //보낸 쪽지 목록 가져옴
		List<MessageDTO> messageGet = messageService.getListAsGetter(memberDTO.getMemberNum()); //받은 쪽지 목록 가져옴
		
		model.addAttribute("giveMsg", messageGive);
		model.addAttribute("getMsg", messageGet);
	}
	
	@DeleteMapping("/message/delete")
	public ResponseEntity<String> deleteMessage(@RequestParam HashMap<Object, Object> params, 
			Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		Long messageNum = Long.parseLong(params.get("messageNum").toString());
		Long view = Long.parseLong(params.get("view").toString());

		MemberDTO memberDTO = memberService.getMemNum(userDetails.getUsername());
		
		MessageDTO messageDTO = messageService.read(messageNum);
		
		if(messageDTO.getMemberGet() == memberDTO.getMemberNum()) {
			messageService.modifyViewAsGetter(messageNum, view);
		}else {
			messageService.modifyViewAsGiver(messageNum, view);
		}
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	
}
