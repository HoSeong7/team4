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

	/** MessageDTO 쪽지번호 pk */
	private Integer messageNum; //
	
	/** MessageDTO 받은사람 */
	private Integer memberGet; //
	
	/** MessageDTO 보낸사람 */
	private Integer memberGive; //
	
	/** MessageDTO 제목 */
	private String title;
	
	/** MessageDTO 내용 */
	private String content;

	/** MessageDTO 보기권한 */
	private Integer view;

	/** MessageDTO 사진 */
	private String url;
	
	/** MessageDTO 등록날짜 */
	protected LocalDateTime regDate;
	
	/** MessageDTO 수정날짜 */
	protected LocalDateTime updateDate;
	
}
