package com.keduit.helloworld.service;

public interface PointPayService {
	
	/** 포인트 증감(update) */
	void modify(Long myNum, Long yourNum, Long payment);
	
}
