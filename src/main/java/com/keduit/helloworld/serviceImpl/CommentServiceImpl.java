package com.keduit.helloworld.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.CommentRepository;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	private final MemberRepository memberRepository;
	
	@Override
	/** 등록 */
	public Long register(CommentDTO commentDTO) {
		Comment comment = dtoToEntity(commentDTO);
		commentRepository.save(comment);
		
		return comment.getBoardCommentNum();
	}

	@Override
	/** 읽기 */
	public List<CommentDTO> getList(Long boardNum) {
		
		List<Comment> comment = commentRepository.getCommentlist(boardNum);
		
		return comment.stream().map(commentarr -> getCommentNum(commentarr)	).collect(Collectors.toList());
		}
//		return null;

	@Override
	/** 수정 */
	public void modify(CommentDTO commentDTO) {
		
		Comment comment = dtoToEntity(commentDTO);
		commentRepository.save(comment);
	}

	@Override
	/** 삭제 */
	public void remove(Long boardCommentNum) {
		
		commentRepository.deleteById(boardCommentNum);
		
	}
	
	public CommentDTO getCommentNum(Comment comment) {
		
		Member member = memberRepository.getCommenter(comment.getCommenterNum());
		return entityToDTO(comment, member);
	}
}
