package com.keduit.helloworld.service;

import com.keduit.helloworld.dto.MemberDTO;

public interface PointPayService {
	
//	/** 포인트 증감(update) */
//	void modify(Long point);

	void modify(MemberDTO memberDTO);
	
}
