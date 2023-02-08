package com.keduit.helloworld.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class FavoritesDTO {
	
	/**즐겨찾기 pk*/
	private Integer favoritesNum;
	/**즐겨찾기 member fk*/
	private Integer bookmarker;
	/**즐겨찾기 member fk*/
	private Integer bookmarked;
	
	/** 즐겨찾기 한 사람이 메인 */
	public void bookmarker(Integer bookmarker) {
		this.bookmarker = bookmarker;
	}
	/** 즐겨찾기 당한 사람이 메인 */
	public void bookmarked(Integer bookmarked) {
		this.bookmarked = bookmarked;
	}
	
	
}
