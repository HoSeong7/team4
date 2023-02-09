//package com.keduit.helloworld.service;
//
//import com.keduit.helloworld.dto.BoardDTO;
//import com.keduit.helloworld.dto.PageRequestDTO;
//import com.keduit.helloworld.dto.PageResultDTO;
//import com.keduit.helloworld.entity.Board;
//
//public interface BoardService {
//
//	Long register(BoardDTO dto);
//	BoardDTO get(Long bno);
//	void removeWithReplies(Long bno);	
//	void modify(BoardDTO boardDTO);
//	PageResultDTO<BoardDTO, Object[]>getList(PageRequestDTO pageRequestDTO);
//	
//	default Board dtoToEntity(BoardDTO dto) {
//		
//		Member member = Member.builder()
//									.email(dto.getWriterEmail())
//									.build();
//		Board board = Board.builder()
//								.bno(dto.getBno())
//								.title(dto.getTitle())
//								.content(dto.getContent())
//								.writer(member)
//								.build();
//		return board;
//	}
//	
//	default BoardDTO entityToDTO(Board board, Member member , Long replyCount) {
//		
//		BoardDTO boardDTO = BoardDTO.builder()
//										.bno(board.getBno())
//										.title(board.getTitle())
//										.content(board.getContent())
//										.regdate(board.getRegDate())
//										.updatedate(board.getUpdateDate())
//										.writerEmail(member.getEmail())
//										.writerName(member.getName())
//										.replyCount(replyCount.intValue())
//										.build();
//		
//		return boardDTO;
//		
//	}
//	
//	
//}
