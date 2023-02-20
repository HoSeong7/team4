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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.MemberService;
import com.keduit.helloworld.service.MessageService;
import com.nimbusds.jose.shaded.json.JSONObject;

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
	/** 쪽지함 메인 = 쪽지 목록(list) */
	public void message(Authentication authentication, Model model) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		/** 조회하는사람 아이디로, 회원번호 가져오기 */
		MemberDTO myMemDTO = memberService.getMemNum(userDetails.getUsername()); //내정보
		
		/** 조회하는 사람 회원번호로, 쪽지 목록 가져오기 */ 
		List<MessageDTO> messageGive = messageService.getListAsGiver(myMemDTO.getMemberNum()); //조회하는 사람이 발신자, 보낸쪽지 목록 가져옴
		List<MessageDTO> messageGet = messageService.getListAsGetter(myMemDTO.getMemberNum()); //조회하는 사람이 수신자, 받은쪽지 목록 가져옴
		
		model.addAttribute("giveMsg", messageGive); //보낸 쪽지 목록
		model.addAttribute("getMsg", messageGet); //받은 쪽지 목록
	}
	
	@PostMapping("/message/read")
	/** 쪽지 상세 조회(read) */
	public ResponseEntity<MessageDTO> read(Long messageNum, Authentication authentication, Model model) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		/** 조회하는 사람 아이디로, 회원번호 가져오기 */
		MemberDTO myMemDTO = memberService.getMemNum(userDetails.getUsername()); //내정보
		
		/** 쪽지 번호, 조회하는 사람 회원번호로 쪽지 상세 조회하기 */
		MessageDTO messageDTO = messageService.read(messageNum, myMemDTO.getMemberNum()); 
		
		model.addAttribute("messageDTO", messageDTO);
		
		return new ResponseEntity<>(messageDTO,HttpStatus.OK);
	}
	
	@PostMapping("/message/register")
	/** 쪽지 등록 = 전송 = 답장 */
	public String register(MessageDTO dto, 
			Authentication authentication, 
			Long boardCommentNum, 
			Long memberGive) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		MemberDTO myMemDTO = memberService.getMemNum(userDetails.getUsername()); //내정보
		MemberDTO yourMemDTO = memberService.read(memberGive); //상대정보
		
		Long returnNum = messageService.register(dto, yourMemDTO.getMemberNum(), myMemDTO.getMemberNum(), boardCommentNum);
		return "redirect:/hello/message";
		
	}
	
	@DeleteMapping("/message/delete")
	public ResponseEntity<String> deleteMessage(@RequestParam HashMap<Object, Object> params, 
			Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		Long messageNum = Long.parseLong(params.get("messageNum").toString());
		Long view = Long.parseLong(params.get("view").toString());

		MemberDTO memberDTO = memberService.getMemNum(userDetails.getUsername());
		
		MessageDTO messageDTO = messageService.read(messageNum, memberDTO.getMemberNum());
		
		if(messageDTO.getMemberGet() == memberDTO.getMemberNum()) {
			messageService.modifyViewAsGetter(messageNum, view);
		}else {
			messageService.modifyViewAsGiver(messageNum, view);
		}
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
}
