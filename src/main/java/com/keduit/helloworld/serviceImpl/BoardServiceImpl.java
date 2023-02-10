package com.keduit.helloworld.serviceImpl;


import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keduit.helloworld.dto.BoardDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.dto.PageResultDTO;
import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.BoardRepository;
import com.keduit.helloworld.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		
		log.info("pageRequestDTO : "+pageRequestDTO);
		
		Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));
		
		Page<Object[]> result = boardRepository.searchPage(
				pageRequestDTO.getType(),
				pageRequestDTO.getKeyword(),
				pageRequestDTO.getPageable(Sort.by("boardNum").descending())
				);
		
		return new PageResultDTO<>(result, fn);
		
		
		
	}

	@Override
	/** 삭제 */
	public void remove(Long boardNum) {
		boardRepository.deleteById(boardNum);
	}

	@Override
	/** 수정 */
	public void modify(BoardDTO boardDTO) {
		Optional<Board> result = boardRepository.findById(boardDTO.getBoardNum());
		
		if(result.isPresent()) {
			Board entity = result.get();
			
			entity.change(boardDTO.getTitle(), boardDTO.getContent());
			boardRepository.save(entity);
		}
	}

	@Override
	/** 하나 읽기 */
	public BoardDTO get(Long boardNum) {
		Object result = boardRepository.getBoardByBno(boardNum);
		
		Object[] arr = (Object[]) result;
		
		return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
	}
	
}
