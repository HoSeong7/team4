package com.keduit.helloworld.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.ManyToAny;

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
@DynamicInsert
public class Member extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** member 테이블 고유 pk */
	private Long memberNum;
	
	@Column(length =30, nullable = false, unique = true)
	/** member ID */
	private String id;
	
	@Column(length = 30, nullable = false)
	/** member 비밀번호 */
	private String pw;
	
	@Column(length = 10, nullable = false)
	/** member 이름 */
	private String name;
	
	@ColumnDefault("0") 
	/** member 현재 가지고있는 포인트 */
	private Long point;
	
	
	/** 권한*/
	private Boolean purview;
	
	@Column(length = 30, nullable = false, unique = true)
	/** member 닉네임 */
	private String nickname;
	
	@Column(length = 1000)
	/** member 자기소개 */
	private String introduce;
	
	@Column(length = 300)
	/** member 이메일 */
	private String email;
	
	@ColumnDefault("0") 
	/** member 경험치(높을수록 티어가오름) */
	private Long exvalue;
	
	@Column(length = 100)
	/** member 사진 */
	private String url;
	
	@ManyToMany
	@JoinTable(
				name = "userRole",
				joinColumns = @JoinColumn(name = "userId"),
				inverseJoinColumns = @JoinColumn(name = "roleId")
			)
	private List<Role> roles = new ArrayList<>();
}
