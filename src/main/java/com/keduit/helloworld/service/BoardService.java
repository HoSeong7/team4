package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.MemberDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Member;

public interface BoardService {

	/** 쓰기 */
	Long register(BoardDTO boardDTO);

	/** 읽기 */
	List<Board> list(BoardDTO boardDTO);

	/** 수정 */
	void modify(Long boardNum);

	/** 삭제 */
	void remove(Long boardNum);

	default BoardDTO entityToDTO(Board entity) {
		
		BoardDTO boardDTO = BoardDTO.builder()
							.boardNum(entity.getBoardNum())
							.title(entity.getTitle())
							.content(entity.getContent())
							.memberNum(entity.getMemberNum())
							.url(entity.getUrl())
							.views(entity.getViews())
							.cnt(entity.getCnt())
							.tag(entity.getTag())
							.boardcase(entity.getBoardcase())
							.regdate(entity.getRegDate())
							.updatedate(entity.getUpdateDate())
							.build();
		
		return boardDTO;
	}

	default Board dtoToEntity(BoardDTO dto) {

		Board board = Board.builder()
						.boardNum(dto.getBoardNum())
						.title(dto.getTitle())
						.content(dto.getContent())
						.memberNum(dto.getMemberNum())
						.url(dto.getUrl())
						.views(dto.getViews())
						.cnt(dto.getCnt())
						.tag(dto.getTag())
						.boardcase(dto.getBoardcase())
						.build();
		
		return board;
	}

}
