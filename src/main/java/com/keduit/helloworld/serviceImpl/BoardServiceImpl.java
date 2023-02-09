package com.keduit.helloworld.serviceImpl;


import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.repository.BoardRepository;
import com.keduit.helloworld.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	/** 생성 */
	public Long register(BoardDTO boardDTO) {
		
		Board board = dtoToEntity(boardDTO);
		
		boardRepository.save(board);
		
		return board.getBoardNum();
	}

	@Override
	/** 읽기 */
	public List<Board> list(BoardDTO boardDTO) {
		
		List<Board> result = boardRepository.findAll();
		
		
		return result;
	}

	@Override
	/** 수정 */
	public void modify(Long boardNum) {
		
		Board board = boardRepository.getById(boardNum);
		
		boardRepository.save(board);
		
		
	}

	@Override
	/** 삭제 */
	public void remove(Long boardNum) {
		boardRepository.deleteById(boardNum);
	}
}
