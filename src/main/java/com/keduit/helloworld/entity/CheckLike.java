package com.keduit.helloworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

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
public class CheckLike {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** 좋아요 확인 고유넘버 */
	private Long checklikeId;
	
	@Column(nullable = false)
	/** 좋아요 확인 좋아요 누른 댓글 */
	private Long commentId;
	
	@ColumnDefault("0")
	@Column(nullable = false)
	/** 좋아요 확인 좋아요 누른 여부 */
	private Long likebool;

}
