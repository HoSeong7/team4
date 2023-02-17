package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.BoardService;
import com.keduit.helloworld.service.CommentService;
import com.keduit.helloworld.service.MemberService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class MemberController {

	//호성
	
	private final MemberService memberService;
	
	
	private final BoardService boardService;
	
	private final CommentService commentService;
	
	@GetMapping("/spacepage")
	public void spacepage(String id, MemberDTO dto, Model model) {
		Member idnum = memberService.idRead(id);
		
		
		
		//들어간사람이 팔로한사람
	    List<Member> folowing = memberService.getMemberMarker(idnum.getMemberNum());
	    //들어간사람을 팔로한 사람
	    List<Member> folower = memberService.getMemberMarked(idnum.getMemberNum());
	    
	    /** 들어간사람 쓴 글 보기 */
	   List<Board> myBoards = boardService.getMyBoardList(idnum.getId());
	   
	   /** 들어간사람 쓴 댓글 불러오기 */
	   List<Comment> myComments = commentService.getCommentList(idnum.getId());
	   
	    model.addAttribute("member",idnum);
	    /**들어간사람 팔로한 사람 목록*/
	    model.addAttribute("following", folowing);
	    /** 들어간사람 팔로한 사람 목록 */
	    model.addAttribute("follower", folower);
	    /** 들어간사람 쓴 글 보기 */
	    model.addAttribute("myBoard",myBoards);
	    /** 들어간사람 쓴 댓글 보기 */
	    model.addAttribute("myComment", myComments);
	    
	    
	}
	//end 호성
}