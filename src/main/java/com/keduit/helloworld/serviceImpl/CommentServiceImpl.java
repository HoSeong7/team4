package com.keduit.helloworld.serviceImpl;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.repository.CommentRepository;
import com.keduit.helloworld.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
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
	// 승민 
    @Override
    public Page<CommentDTO> getComments(Pageable pageable) {
        return commentRepository.findAll(pageable).map(comment -> commentETD(comment));
    }

	@Override
	public Page<CommentDTO> getKeywordComments(String select,String keyword, Pageable pageable) {

		Page<CommentDTO> list = null;

		if(select.equals("board_comment_num")){
			Optional<Comment> result = commentRepository.findById(Long.parseLong(keyword));
			if(result.isPresent()){
				CommentDTO commentDTO = commentETD(result.get());
				list = new PageImpl<>(Collections.singletonList(commentDTO));
			}
		}else if(select.equals("commenter_num")){
			list = commentRepository.findByCommenterNum(keyword, pageable).map(comment -> commentETD(comment));
		}

		return list;
	}
	// 승민 끝

	@Override
	public List<Comment> getCommentList(String id) {

		List<Comment> comments = commentRepository.getCommentById(id);
		return comments;
	}
}
