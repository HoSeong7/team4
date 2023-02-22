package com.keduit.helloworld.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.keduit.helloworld.dto.BoardCheckLikeDTO;
import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.service.BoardCheckLikeService;
import com.keduit.helloworld.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {
	
	private final CommentService commentService;
	
	@GetMapping("/{boardNum}/all")
	public ResponseEntity<List<CommentDTO>> getListByBoard(@PathVariable("boardNum") Long boardNum){
		log.info("위치 : CommentController getListByBoard()" + boardNum);
		log.info("boardNum : " + boardNum);
		
		return new ResponseEntity<>(commentService.getList(boardNum),HttpStatus.OK);
	}
	
	@PostMapping("/{boardNum}")
	public ResponseEntity<Long> register(@RequestBody CommentDTO commentDTO){
		log.info("위치 : CommentController PostMapping register()");
		log.info("commentDTO : " + commentDTO);
		Long boardCommentNum = commentService.register(commentDTO);
		return new ResponseEntity<Long>(boardCommentNum, HttpStatus.OK);
	}
	
	@DeleteMapping("/{boardCommentNum}")
	public ResponseEntity<String> remove(@PathVariable("boardCommentNum") Long boardCommentNum){
		log.info("위치 : CommentController remove()");
		log.info("boardCommentNum : " + boardCommentNum);
		commentService.remove(boardCommentNum);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@PutMapping("/{boardCommentNum}")
	public ResponseEntity<String> modify(@RequestBody CommentDTO commentDTO){
		log.info("위치 : CommentController modify()");
		log.info("commentDTO : " + commentDTO);
		commentService.modify(commentDTO);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@PostMapping("/readModal")
	public @ResponseBody CommentDTO readModal(@RequestParam HashMap<Object,Object> params){

		Long BCN = Long.parseLong(params.get("boardCommentNum").toString());

		CommentDTO commentDTO = commentService.getById(BCN);

		return commentDTO;
	}
	
	
	
}
