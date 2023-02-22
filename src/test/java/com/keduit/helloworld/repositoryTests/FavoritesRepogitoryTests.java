package com.keduit.helloworld.repositoryTests;

import java.util.List;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keduit.helloworld.dto.FavoritesDTO;
import com.keduit.helloworld.entity.Favorites;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.FavoritesRepository;
import com.keduit.helloworld.repository.MemberRepository;

@SpringBootTest
public class FavoritesRepogitoryTests {

	@Autowired
	private FavoritesRepository favoritesRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void insertTest() {
		Member member = new Member();
		
		IntStream.rangeClosed(1, 200).forEach(i->{
			
			long a = (long)(Math.random()*10)+1;
			long b = (long)(Math.random()*10)+1;
			
			Favorites entity = Favorites.builder().bookmarked(a)
												  .bookmarker(b).build();
			favoritesRepository.save(entity);
			
		});
	}
	@Test
	public void selectTest() {
		
		List<Member> member = memberRepository.getMemberMarker(1L);

		
		for(Member i : member) {
			System.out.println(i.getId()+ " , " + i.getNickname());
			
		}
	}
	

	
}
