package com.keduit.helloworld.service;

import com.keduit.helloworld.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import com.keduit.helloworld.entity.Comment;

import java.util.List;

import com.keduit.helloworld.dto.CommentDTO;
import com.keduit.helloworld.entity.Comment;
import com.keduit.helloworld.entity.Member;

public interface CommentService {

    Page<CommentDTO> getComments(PageRequest commentPageRequest);

	List<Comment> getCommentList(String id);


	/** 생성 */
	Long register(CommentDTO commentDTO);

	/** 읽기 */
	List<CommentDTO> getList(Long boardNum);

	/** 수정 */
	void modify(CommentDTO commentDTO);

	/** 삭제 */
	void remove(Long rno);

	default Comment dtoToEntity(CommentDTO commentDTO) {

		Comment comment = Comment.builder()
				.boardCommentNum(commentDTO.getBoardCommentNum())
				.boardNum(commentDTO.getBoardNum())
				.commentContent(commentDTO.getCommentContent())
				.viewpicture(commentDTO.getViewpicture())
				.price(commentDTO.getPrice())
				.url(commentDTO.getUrl())
				.clikes(commentDTO.getClikes())
				.commenterNum(commentDTO.getCommenterNum())
				.build();
		return comment;
	}

	default CommentDTO entityToDTO(Comment comment, Member member) {
		CommentDTO replyDTO = CommentDTO.builder()
				.boardCommentNum(comment.getBoardCommentNum())
				.boardNum(comment.getBoardNum())
				.commentContent(comment.getCommentContent())
				.viewpicture(comment.getViewpicture())
				.price(comment.getPrice())
				.url(comment.getUrl())
				.clikes(comment.getClikes())
				.id(member.getId())
				.nickname(member.getNickname())
				.commenterNum(comment.getCommenterNum())
				.regdate(comment.getRegDate())
				.updatedate(comment.getUpdateDate())
				.build();
		return replyDTO;
	}
}
