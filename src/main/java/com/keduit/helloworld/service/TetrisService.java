package com.keduit.helloworld.service;

import java.util.List;

import com.keduit.helloworld.entity.Tetris;

public interface TetrisService {

	/** 점수 등록 */
	void insertNum(Long memberNum, Long score);

	/** 상위 일단 3명 출력*/
	List<Tetris> getMax3();

}
