package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.dto.PageResultDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.repository.BoardRepository;
import com.keduit.helloworld.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	private final BoardService boardService;

    @GetMapping("/communitylist")
    public void communitylist(PageRequestDTO pageRequestDTO,Model model){
    	log.info("위치 : BoardController communitylist()");
    	log.info("pageRequestDTO : " + pageRequestDTO);
    	PageResultDTO<BoardDTO, Object[]> result = boardService.getBoard1List(pageRequestDTO);
    	log.info("뿌림?" + result);
    	
		model.addAttribute("result",boardService.getBoard1List(pageRequestDTO));
	}
    @GetMapping("/noticelist")
    public void noticelist(PageRequestDTO pageRequestDTO,Model model){
    	log.info("위치 : BoardController noticelist()");
    	log.info("pageRequestDTO : " + pageRequestDTO);
    	PageResultDTO<BoardDTO, Object[]> result = boardService.getBoard2List(pageRequestDTO);
    	log.info("2뿌림?" + result);
    	
		model.addAttribute("result",boardService.getBoard2List(pageRequestDTO));
    }
    @GetMapping("/qnalist")
    public void qnalist(PageRequestDTO pageRequestDTO,Model model){
    	log.info("위치 : BoardController qnalist()");
    	log.info("pageRequestDTO : " + pageRequestDTO);
    	PageResultDTO<BoardDTO, Object[]> result = boardService.getBoard3List(pageRequestDTO);
    	log.info("뿌림?" + result);
    	
		model.addAttribute("result",boardService.getBoard3List(pageRequestDTO));
    }
    
	@GetMapping({"/communityregister","/noticeregister","/qnaregister"})
	public void register() {
		log.info("등록페이지");
	}
	
	@PostMapping({"/communityregister","/noticeregister","/qnaregister"})
	public String register(BoardDTO dto, RedirectAttributes redirectAttributes) {
		log.info("위치 : BoardController register()");
		log.info("dto : " + dto);
		Long boardnum = boardService.register(dto);
		
		log.info("boardnum : " + boardnum);
		redirectAttributes.addFlashAttribute("msg",boardnum);
		return "redirect:/hello/communitylist";
	}
	
	@GetMapping({"/communityread", "/noticeread","/qnaread"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , Long boardNum , Model model) {
		
		log.info("위치 : BoardController read()");
		log.info("boardNum : " + boardNum);
		
		Board board = boardRepository.findById(boardNum).get();
		Long countViews = board.getViews()+1L;
		
		BoardDTO boardDTO = BoardDTO.builder().views(countViews).build();
		
		boardService.updateViews(boardNum, boardDTO);
		
		boardDTO = boardService.get(boardNum);
		
		
		log.info(boardDTO);
		model.addAttribute("dto",boardDTO);
		
	}
	
	@GetMapping({"/communitymodify","/noticemodify","/qnamodify"})
	public void modify(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , Long boardNum , Model model) {
		
		log.info("위치 : BoardController read()");
		log.info("bno : " + boardNum);
		BoardDTO boardDTO = boardService.get(boardNum);
		
		log.info(boardDTO);
		model.addAttribute("dto",boardDTO);
		
	}
	
	
	@PostMapping({"/communityremove","/noticeremove","/qnaremove"})
	public String remove(long boardNum, RedirectAttributes redirectAttributes) {
		
		log.info("위치 : BoardController remove()");
		log.info("boardNum : " + boardNum);
		boardService.remove(boardNum);
		redirectAttributes.addFlashAttribute("msg",boardNum);
		return "redirect:/hello/communitylist";
	}
	
	@PostMapping({"/communitymodify","/noticemodify","/qnamodify"})
	public String modify(BoardDTO boardDTO,@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , RedirectAttributes redirectAttributes) {
		log.info("위치 : BoardController modify()");
		log.info("dto : " + boardDTO);
		
		boardService.modify(boardDTO);
		redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
		redirectAttributes.addAttribute("type", pageRequestDTO.getType());
		redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
		redirectAttributes.addAttribute("boardNum", boardDTO.getBoardNum());
		
		return "redirect:/hello/communityread";
	}
	

}
