package com.keduit.helloworld.repositoryTests;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.entity.Board;
import com.keduit.helloworld.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	/** 더미생성 */
	public void insertBoardTest() { // 더미
		
		IntStream.rangeClosed(1, 100).forEach(i ->{
			Board board = Board.builder()
							.title("제목 -- " + i)
							.content("내용 -- " + i)
							.tag("JAVA")
							.boardcase(1L)
							.memberNum(2L)
							.build();
			
			boardRepository.save(board);
		});
		
	}
	
	@Test
	/** 읽기 */
	public void selectBoardTest() {
		System.out.println("타냐");
		Optional<Board> result = boardRepository.findById(2L);
		
		System.out.println(result);
	}
	
	@Test
	/** 수정 */
	public void updateBoardTest() {
		Board board = Board.builder()
							.boardNum(2L)
							.title("수정된 -- 1")
							.content("수정된 내용 -- 1")
							.build();
		
		System.out.println(boardRepository.save(board));
	}
	
	@Test
	/** 삭제 */
	public void deleteBoard() {
		boardRepository.deleteById(2L);
	}
	
	@Test
	public void testReadOne() {
		Object result = boardRepository.getBoardByBno(47L);
		
		Object[] arr = (Object[])result;
		
		System.out.println(Arrays.toString(arr));
		
	}

}
