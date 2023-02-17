package com.keduit.helloworld.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.entity.Message;
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

		/** 보낸사람 회원번호로 내가 보낸 사람, 메시지 정보 가져오기 */
		List<Message> message = messageService.getMsgListAsGiver(userDetails.getUsername()); 

		/** 내가 보낸 사람, 내 정보 */
		List<Member> member = memberService.getMsgById(message.get(0).getMemberGive()); //username=회원아이디

		model.addAttribute("getMem", member);
		model.addAttribute("getMsg", message);

	}
}
