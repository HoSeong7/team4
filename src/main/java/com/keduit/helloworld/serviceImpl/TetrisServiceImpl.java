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
	public void insertNum(Long memberNum, Long score) {

		Tetris entity = Tetris.builder()
							.memberNum(memberNum)
							.score(score)
							.build();
		tetrisRepository.save(entity);
	}

	@Override
	public List<Tetris> getMax3() {

		List<Tetris> tetris = tetrisRepository.max3();
		
		return tetris;
	}

}
