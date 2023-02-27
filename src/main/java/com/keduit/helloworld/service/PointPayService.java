package com.keduit.helloworld.service;

import com.keduit.helloworld.dto.PointAccountDTO;
import com.keduit.helloworld.entity.PointAccount;

public interface PointPayService {
	
	/** 포인트 증감(update) */
	void modify(Long myNum, Long yourNum, Long payment);
	
	//테스트 중
	public boolean chargePoint(Long memberNum, Long charge);
	//테스트 끝
}