package com.keduit.helloworld.controller;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.dto.MessageDTO;
import com.keduit.helloworld.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class AdminController {

    private final AdminService adminService;
    private final MemberService memberService;
    private final BoardService boardService;
    private final CommentService commentService;
    private final MessageService messageService;

    @GetMapping("/admin")
    public void adminPage(Model model, @RequestParam(defaultValue = "0") int memberPage,
                          @RequestParam(defaultValue = "0") int boardPage,
                          @RequestParam(defaultValue = "0") int commentPage,
                          @RequestParam(defaultValue = "0") int messagePage) {

        // 멤버 페이징 처리
        PageRequest memberPageRequest = PageRequest.of(memberPage, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<MemberDTO> memberList = memberService.getMembers(memberPageRequest);
        model.addAttribute("memberList", memberList);

        // 게시물 페이징 처리
        PageRequest boardPageRequest = PageRequest.of(boardPage, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<BoardDTO> boardList = boardService.getBoards(boardPageRequest);
        model.addAttribute("boardList", boardList);

        // 댓글 페이징 처리
        PageRequest commentPageRequest = PageRequest.of(commentPage, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<CommentDTO> commentList = commentService.getComments(commentPageRequest);
        model.addAttribute("commentList", commentList);

        // 메시지 페이징 처리
        PageRequest messagePageRequest = PageRequest.of(messagePage, 10, Sort.by(Sort.Direction.DESC, "id"));
        Page<MessageDTO> messageList = messageService.getMessages(messagePageRequest);
        model.addAttribute("messageList", messageList);
    }

}
