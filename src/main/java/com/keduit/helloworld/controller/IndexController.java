package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.dialect.identity.CockroachDB1920IdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.BoardService;
import com.keduit.helloworld.service.MemberService;
import com.nimbusds.jose.shaded.json.JSONObject;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class IndexController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;

    @GetMapping("/main")
    public void index(){
        log.info("IndexController index");
    }
    
    @GetMapping("/index")
    public void indexpage(String dto){
    	log.info("여기는 겟 인덱스" + dto);
    }
    
    @PostMapping("/index")
    public String indexpage2() {
    	log.info("여기는 포스트 인덱스");
    	
    	return "/hello/index";
    }
    
    @GetMapping("/login")
    public void loginpage(String err, String logout) {
    	log.info("여기는 겟 로그인");
    }
    
    @PostMapping("/login")
    public String loginpage2() {
    	
    	return "/hello/index";
    }
    
    @GetMapping("/register")
    public void register() {
    }
    
    @PostMapping("/register")
    public String register(MemberDTO memberDTO,RedirectAttributes redirectAttributes) {
    	
    	Long memberNun = memberService.register(memberDTO);
    	redirectAttributes.addFlashAttribute("msg", memberNun);
    	
    	return "redirect:/hello/index";
    }
    
    @GetMapping("/modify")
    public void modify() {
    	
    }
    
    @PostMapping("/modify")
    public String modify(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
    	memberService.modify(memberDTO);
    	System.out.println(memberDTO);
    	
    	return "redirect:/hello/myspace";
    }
    
    @GetMapping("/myspace")
    public void myspace(Authentication authentication,@ModelAttribute("dto") Member member, Model model) {
    	
    	 UserDetails userDetails = (UserDetails)authentication.getPrincipal();
    	    System.out.println("username = " + userDetails.getUsername());
    	    System.out.println("role = " + userDetails.getAuthorities().stream().map(r -> String.valueOf(r)).collect(Collectors.joining(",")));
    	
    	    Member idnum =  memberService.idRead(userDetails.getUsername());
    	    //내가 팔로한사람
    	    List<Member> folowing = memberService.getMemberMarker(idnum.getMemberNum());
    	    //나를 팔로한 사람
    	    List<Member> folower = memberService.getMemberMarked(idnum.getMemberNum());
    	    
    	    /** 내가 쓴 글 보기 */
    	   List<Board> myBoards = boardService.getMyBoardList(idnum.getId());
    	    
    	    model.addAttribute("member",idnum);
    	    /**내가 팔로한 사람 목록*/
    	    model.addAttribute("following", folowing);
    	    /** 나를 팔로한 사람 목록 */
    	    model.addAttribute("follower", folower);
    	    
    	    model.addAttribute("myBoard",myBoards);
    
    	    log.info(idnum);
    	        
   }
    
  
}
