package com.keduit.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.service.MessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class MessageController {

	private final MessageService messageService;
	
	@GetMapping("/message")
	public void message(Model model) {
		log.info("=============== MessageController ===============");
		int membernum = 5;
		MessageDTO dto = new MessageDTO();
		
		dto.getMemberGet();
		dto.getMemberGive();
	}
	
	
	
//	@GetMapping(value = "/message")
//	/** 쪽지 리스트 조회(read, 받은사람 기준) */
//	public ResponseEntity <List<MessageDTO>> getMsgListAsGetter(@PathVariable("memberGet") Long memberGet){
//		
//		log.info("=============== MessageController ===============");
//		
//		return new ResponseEntity(messageService.getListAsGetter(memberGet), HttpStatus.OK);
//	}
	



}
