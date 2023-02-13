package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	

	private final BoardService boardService;

    @GetMapping("/board")
    public void board(PageRequestDTO pageRequestDTO,Model model){
    	log.info("위치 : BoardController board()");
    	log.info("pageRequestDTO : " + pageRequestDTO);
		model.addAttribute("result",boardService.getBoard1List(pageRequestDTO));
	}
    
	@GetMapping("/boardpostpage")
	public void register() {
		log.info("등록페이지");
	}
	
	@PostMapping("/boardpostpage")
	public String register(BoardDTO dto, RedirectAttributes redirectAttributes) {
		log.info("위치 : BoardController register()");
		log.info("dto : " + dto);
		Long boardnum = boardService.register(dto);
		
		log.info("boardnum : " + boardnum);
		redirectAttributes.addFlashAttribute("msg",boardnum);
		return "redirect:/board/board";
	}
	
	@GetMapping({"/boardlist", "/modify"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , Long boardNum , Model model) {
		
		log.info("bno : " + boardNum);
		BoardDTO boardDTO = boardService.get(boardNum);
		
		log.info(boardDTO);
		model.addAttribute("dto",boardDTO);
		
	}
	
	@PostMapping("/remove")
	public String remove(long boardNum, RedirectAttributes redirectAttributes) {
		log.info("bno : " + boardNum);
		boardService.remove(boardNum);
		redirectAttributes.addFlashAttribute("msg",boardNum);
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO boardDTO,@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , RedirectAttributes redirectAttributes) {
		log.info("=======================");
		log.info("dto : " + boardDTO);
		
		boardService.modify(boardDTO);
		redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
		redirectAttributes.addAttribute("type", pageRequestDTO.getType());
		redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
		redirectAttributes.addAttribute("bno", boardDTO.getBoardNum());
		
		return "redirect:/board/read";
	}
	

}
