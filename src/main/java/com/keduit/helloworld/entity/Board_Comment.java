package com.keduit.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
public class Board_Comment extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** Board_comment 고유번호 pk */
	private Integer boardCommentNum;
	
	/** member 테이블과 fk  */
	private Integer boardNum;    // 맴버 테이블과 fk
	
	@Column(length = 1000, nullable = false)
	/** Board_comment 내용 */
	private String commentContent;  
	
	@Column(length = 100, nullable = false)
	/** Board_comment 미리보기 사진 */
	private String viewUrl;
	
	@ColumnDefault("0")
	/** Board_comment 가격 */
	private Integer price;
	
	@Column(length = 100)
	/** Board_comment 사진 */
	private String url;
	
	
	
}
