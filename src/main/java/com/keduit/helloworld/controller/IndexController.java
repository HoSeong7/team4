package com.keduit.helloworld.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.dialect.identity.CockroachDB1920IdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.service.BoardService;
import com.keduit.helloworld.service.CommentService;
import com.keduit.helloworld.service.MemberService;
import com.nimbusds.jose.shaded.json.JSONObject;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hello/*")
public class IndexController {
	
	
	private final MemberService memberService;
	
	
	private final BoardService boardService;
	
	private final CommentService commentService;

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
    	log.info("여기는 겟 레지스터");
    }
    
    @PostMapping("/register")
    public String register(MemberDTO memberDTO,RedirectAttributes redirectAttributes) {
    	
    	log.info("여기는 포스트 레지스터");
    	
    	Long memberNun = memberService.register(memberDTO);
    	redirectAttributes.addFlashAttribute("msg", memberNun);
    	
    	return "redirect:/hello/index";
    }
    
    //호성 23.02.18
    /** id ajax로 가져오기 중복체크*/
    @PostMapping("/register/{id}")
    public ResponseEntity<Integer> idChk(@PathVariable("id") String id){
   
    	System.out.println( "register에서 찍히나 ?? "+id);
	   	int idChk = memberService.memberCount(id);
  	
        return new ResponseEntity<>(idChk,HttpStatus.OK);
    }
    /** nickname ajax로 가져오기 중복체크*/
    @PostMapping("/register/chk/{nick}")
    public ResponseEntity<Integer> nickChk(@PathVariable("nick") String nickname){
   
    	System.out.println( "register에서 찍히나 ?? "+nickname);
	   	int idChk = memberService.membernickCount(nickname);
  	
        return new ResponseEntity<>(idChk,HttpStatus.OK);
    }
    
    // end 호성
    
    @GetMapping("/modify")
    public void modify() {
    	
    }
    
    @PostMapping("/modify")
    public String modify(MemberDTO memberDTO,RedirectAttributes redirectAttributes) {
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
    	   
    	   /** 내가 쓴 댓글 불러오기 */
    	   List<Comment> myComments = commentService.getCommentList(idnum.getId());
    	   
    	    model.addAttribute("member",idnum);
    	    /**내가 팔로한 사람 목록*/
    	    model.addAttribute("following", folowing);
    	    /** 나를 팔로한 사람 목록 */
    	    model.addAttribute("follower", folower);
    	    /** 내가 쓴 글 보기 */
    	    model.addAttribute("myBoard",myBoards);
    	    /** 내가 쓴 댓글 보기 */
    	    model.addAttribute("myComment", myComments);
    	    
    	    log.info(idnum);
    	        
   }
    

    
    
  
}
