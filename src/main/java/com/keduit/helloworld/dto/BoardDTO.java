package com.keduit.helloworld.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

	
	/** Board 고유 pk */
	private Integer boardNum;
	
	/** Board 제목 */
	private String title;
	
	/** Board 내용 */
	private String content;
	
	/** member테이블과 fk */
	private Integer memberNum;
	
	/** Board 사진 */
	private String url;
	
	/** Board 조회수 */
	private Integer views;
	
	/** Board 댓글수 */
	private Integer cnt;
	
	/** Board 해시태그 */
	private String tag;
	
	/** Board_comment 작성,수정 날짜 */
	private LocalDateTime regdate, updatedate; 
}
