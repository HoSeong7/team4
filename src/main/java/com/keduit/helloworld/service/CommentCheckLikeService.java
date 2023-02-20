package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.dto.PageResultDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CommentCheckLikeService {

	/** 쓰기 */
	Long register(BoardDTO boardDTO);

	/** 읽기 */
	PageResultDTO<BoardDTO, Object[]>getBoard1List(PageRequestDTO pageRequestDTO);
	PageResultDTO<BoardDTO, Object[]>getBoard2List(PageRequestDTO pageRequestDTO);
	PageResultDTO<BoardDTO, Object[]>getBoard3List(PageRequestDTO pageRequestDTO);

	/** 수정 */
	void modify(BoardDTO boardDTO);

	/** 삭제 */
	void remove(Long boardNum);
	
	/** 하나 읽어오기 */
	BoardDTO get(Long boardNum);
	

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
	
	
	default BoardDTO entityToDTO(Board entity, Member member , Long cnt) {
		

		BoardDTO boardDTO = BoardDTO.builder()
							.boardNum(entity.getBoardNum())
							.title(entity.getTitle())
							.content(entity.getContent())
							.id(member.getId())
							.nickname(member.getNickname())
							.url(entity.getUrl())
							.views(entity.getViews())
							.cnt(cnt.longValue())
							.tag(entity.getTag())
							.blikes(entity.getBlikes())
							.boardcase(entity.getBoardcase())
							.regdate(entity.getRegDate())
							.updatedate(entity.getUpdateDate())
							.memberNum(entity.getMemberNum())
							.build();
		
		return boardDTO;
	}

	public void updateViews(Long boardNum, BoardDTO boardDTO);
	List<Board> getMyBoardList(String id);


	Page<BoardDTO> getBoards(PageRequest boardPageRequest);
}
