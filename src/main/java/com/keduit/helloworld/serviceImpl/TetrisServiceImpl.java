package com.keduit.helloworld.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.helloworld.entity.Tetris;
import com.keduit.helloworld.repository.TetrisRepository;
import com.keduit.helloworld.service.TetrisService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TetrisServiceImpl implements TetrisService {
	
	private final TetrisRepository tetrisRepository;

	@Override
	public void insertNum(String username, Long max) {

		Tetris entity = Tetris.builder()
							.id(username)
							.score(max)
							.build();
		tetrisRepository.save(entity);
	}

	@Override
	public List<Tetris> getMax3() {

		List<Tetris> tetris = tetrisRepository.max3();
		
		return tetris;
	}

}
