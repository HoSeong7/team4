package com.keduit.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Message extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //pk, nn, ai
	private int messageNum; //쪽지번호
	
	@Column(nullable = false) //fk, nn | 회원번호(멤버):받은사람 = 1:n
	private int memberGet; //받은사람

	@Column(nullable = false) //fk, nn | 회원번호(멤버):보낸사람 = 1:n
	private int memberGive; //보낸사람
	
	@Column(length = 100, nullable = false) //nn
	private String title; //제목
	
	@Column(length = 3000, nullable = false) //nn
	private String content; //내용
	
	@Column
	private int view; //보기권한
	
	@Column(length = 100)
	private String url; //사진
	
}
