package com.keduit.helloworld.controller;

import com.keduit.helloworld.dto.*;
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
    private final CouponService couponService;

    @GetMapping("/admin")
    public void adminPage(Model model,
                          @RequestParam(defaultValue = "0") int memberPage,
                          @RequestParam(defaultValue = "0") int boardPage,
                          @RequestParam(defaultValue = "0") int commentPage,
                          @RequestParam(defaultValue = "0") int messagePage,
                          @RequestParam(defaultValue = "0") int couponPage,
                          @RequestParam(required = false) String memberName,
                          @RequestParam(required = false) String boardTitle,
                          @RequestParam(required = false) String commentContent,
                          @RequestParam(required = false) String messageNum,
                          @RequestParam(required = false) String messageGive,
                          @RequestParam(required = false) String messageGet,
                          @RequestParam(required = false) String memberSelect,
                          @RequestParam(required = false) String boardSelect,
                          @RequestParam(required = false) String commentSelect,
                          @RequestParam(required = false) String messageSelect) {

        // 멤버 페이징 처리
        PageRequest memberPageRequest = PageRequest.of(memberPage, 10, Sort.by(Sort.Direction.DESC, "memberNum"));

        Page<MemberDTO> memberList;
        if (memberName != null) {
            memberList = memberService.getKeywordMembers(memberSelect, memberName, memberPageRequest);
        } else {
            memberList = memberService.getMembers(memberPageRequest);
        }

        model.addAttribute("memberList", memberList);

        // 게시물 페이징 처리
        PageRequest boardPageRequest = PageRequest.of(boardPage, 10, Sort.by(Sort.Direction.DESC, "boardNum"));

        Page<BoardDTO> boardList;
        if (boardTitle != null) {
            boardList = boardService.getKeywordBoards(boardSelect, boardTitle, boardPageRequest);
        } else {
            boardList = boardService.getBoards(boardPageRequest);
        }
        model.addAttribute("boardList", boardList);

        // 댓글 페이징 처리

        PageRequest commentPageRequest = PageRequest.of(commentPage, 10, Sort.by(Sort.Direction.DESC, "boardCommentNum"));
        Page<CommentDTO> commentList;
        if(commentContent != null){
            commentList = commentService.getKeywordComments(commentSelect, commentContent, commentPageRequest);
        }else {
            commentList = commentService.getComments(commentPageRequest);
        }
        model.addAttribute("commentList", commentList);

        // 메시지 페이징 처리
        PageRequest messagePageRequest = PageRequest.of(messagePage, 10, Sort.by(Sort.Direction.DESC, "messageNum"));
        Page<MessageDTO> messageList;
        if ((messageGive != null)&&(messageGet != null)&&(messageNum != null)) {
            messageList = messageService.getKeywordMessages(messageSelect, messageGive, messageGet, messageNum, messagePageRequest);
        }else {
            messageList = messageService.getMessages(messagePageRequest);
        }
        model.addAttribute("messageList", messageList);

        PageRequest commentPageReq = PageRequest.of(couponPage, 10,Sort.by(Sort.Direction.DESC,"couponNum"));
        Page<CouponDTO> couponList = couponService.readCouponList(commentPageReq);
        model.addAttribute("couponList",couponList);
    }

    @GetMapping("/createCoupon")
    public String createCoupon(){
        couponService.couponCreate();
        return "redirect:/hello/admin";
    }

}
