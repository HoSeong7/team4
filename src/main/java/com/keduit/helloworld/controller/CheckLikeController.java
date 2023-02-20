package com.keduit.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keduit.helloworld.dto.BoardCheckLikeDTO;
import com.keduit.helloworld.service.BoardCheckLikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/like/*")
public class CheckLikeController {
	

	
	private final BoardCheckLikeService boardCheckLikeService;
	
	@PostMapping("/{boardNum}")
	public ResponseEntity<Long> register(@RequestBody BoardCheckLikeDTO boardCheckLikeDTO){
		log.info("위치 : CommentController register()");
		log.info("boardCheckLikeDTO : " + boardCheckLikeDTO);
		log.info("나오냐 " + boardCheckLikeDTO.getMemberNum() + boardCheckLikeDTO.getBoardNum());
		
		boardCheckLikeService.get(boardCheckLikeDTO.getMemberNum(), boardCheckLikeDTO.getBoardNum());
		//Long checklikeId = boardCheckLikeService.register(boardCheckLikeDTO);
		return new ResponseEntity<Long>(1L, HttpStatus.OK);
	}
	
	@DeleteMapping("/{boardNum}/{boardCommentNum}")
	public ResponseEntity<String> remove(@PathVariable("boardCommentNum") Long checklikeId){
		log.info("위치 : CommentController remove()");
		log.info("boardCommentNum : " + checklikeId);
		boardCheckLikeService.remove(checklikeId);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	
	
	
}
