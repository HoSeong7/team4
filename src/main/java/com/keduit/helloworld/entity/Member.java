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
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** member 테이블 고유 pk */
	private Integer memberNum;
	
	@Column(length =30, nullable = false, unique = true)
	/** member ID */
	private String id;
	
	@Column(length = 30, nullable = false)
	/** member 비밀번호 */
	private String pw;
	
	@Column(length = 10, nullable = false)
	/** member 이름 */
	private String memberName;
	
	@Column(columnDefinition = "INT DEFAULT 0") //columnDefinition = "DATE DEFAULT SYSDATE"
	/** member 현재 가지고있는 포인트 */
	private Long point;
	
	@Column(columnDefinition = "INT DEFAULT 0")
	/** 권한 0 : 일반  1 : 관리자 */
	private Integer purview;
	
	@Column(length = 30, nullable = false, unique = true)
	/** member 닉네임 */
	private String nickname;
	
	@Column(length = 1000)
	/** member 자기소개 */
	private String introduce;
	
	@Column(length = 300)
	/** member 이메일 */
	private String email;
	
	@Column(columnDefinition = "INT DEFAULT 0")
	/** member 경험치(높을수록 티어가오름) */
	private Long value;
	
	@Column(length = 100)
	/** member 사진 */
	private String url;
	
	
}
