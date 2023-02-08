package com.keduit.helloworld.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	private Integer messageNum; //쪽지번호
	private Integer memberGet; //받은사람
	private Integer memberGive; //보낸사람
	private String title; //제목
	private String content; //내용
	private Integer view; //보기권한
	private String url; //사진
	protected LocalDateTime regDate; //등록날짜
	protected LocalDateTime updateDate; //수정날짜
	
}
