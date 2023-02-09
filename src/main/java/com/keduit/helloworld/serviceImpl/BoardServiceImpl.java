//package com.keduit.helloworld.serviceImpl;
//
//import com.keduit.helloworld.service.BoardDTO;
//import com.keduit.helloworld.service.BoardService;
//import com.keduit.helloworld.service.PageRequestDTO;
//import com.keduit.helloworld.service.PageResultDTO;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class BoardServiceImpl implements BoardService {
//	
//	private final BoardRepository repository;
//	private final ReplyRepository replyRepository;	
//	
//	@Override
//	public Long register(BoardDTO boardDTO) {
//		
//		log.info("위치 : BoardServiceImpl register()");
//		log.info("BoardDTO : " + boardDTO);
//		
//		Board board = dtoToEntity(boardDTO);
//		
//		repository.save(board);
//		
//		return board.getBno();
//	}
//
//	@Override
//	public BoardDTO get(Long bno) {
//		
//		log.info("위치 : BoardServiceImpl get()");
//		
//		Object result = repository.getBoardByBno(bno);
//		
//		Object[] arr = (Object[]) result;
//		
//		return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
//	}
//
//	@Transactional
//	@Override
//	public void removeWithReplies(Long bno) {
//		
//		replyRepository.deleteByBno(bno);
//		repository.deleteById(bno);
//		
//	}
//
//	@Override
//	public void modify(BoardDTO boardDTO) {
//		
//		Board board = repository.getById(boardDTO.getBno());
//		
//		if(board != null) {
//			board.change(boardDTO.getTitle(), boardDTO.getContent());
//		}
//		
//		repository.save(board);
//		
//	}
//
//	@Override
//	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
//		
//		log.info("pageRequestDTO : "+pageRequestDTO);
//		
//		Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));
//		
////		Page<Object[]> result = repository.getBoardWithReplyCount(
////				pageRequestDTO.getPageable(Sort.by("bno").descending())
////				);
//		
//		Page<Object[]> result = repository.searchPage(
//				pageRequestDTO.getType(),
//				pageRequestDTO.getKeyword(),
//				pageRequestDTO.getPageable(Sort.by("bno").descending())
//				);
//		
//		return new PageResultDTO<>(result, fn);
//		
//	}
//
//}
