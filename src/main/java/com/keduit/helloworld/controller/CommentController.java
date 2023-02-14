package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.service.CommentService;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {
	
	private final CommentService commentService;
	
	@GetMapping(value="/hello/{boardNum}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getListByBoard(@PathVariable("boardNum") Long boardNum){
		log.info("위치 : CommentController getListByBoard()" + boardNum);
		log.info("boardNum : " + boardNum);
		
		return new ResponseEntity<>(commentService.getList(boardNum),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody CommentDTO commentDTO){
		log.info("위치 : CommentController register()");
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
	
	
	
	
	
	
	
}
