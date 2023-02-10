package com.keduit.helloworld.serviceImpl;





import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.keduit.helloworld.dto.FavoritesDTO;
import com.keduit.helloworld.dto.PageRequestDTO;
import com.keduit.helloworld.dto.PageResultDTO;
import com.keduit.helloworld.entity.Favorites;
import com.keduit.helloworld.entity.Member;
import com.keduit.helloworld.repository.FavoritesRepository;
import com.keduit.helloworld.repository.MemberRepository;
import com.keduit.helloworld.service.FavoritesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class FavoritesServiceImpl implements FavoritesService {

	private final FavoritesRepository favoritesRepository;
	private final MemberRepository memberRepository;
	
	@Override
	/** 즐겨찾기 추가하기, 리턴값 bookmarked */
	public Long register(FavoritesDTO dto) {
		log.info("Favorites ServiceImpl ------------" + dto);
		
		Favorites entity = DtoToEntity(dto);
		log.info("Favorites DTO 에서 Entity로 값 넣기 " + entity);
		favoritesRepository.save(entity);
		
		return entity.getBookmarked();
	}

	@Override
	/** bookmarker를 입력받으면 현재 즐겨찾기 추가한 사람을 볼 수 있음*/
	public List<Member> read(FavoritesDTO dto) {
		
		List<Member> result = memberRepository.getMemberMarker(dto.getBookmarker());
				
		
			
			
			return result;
	}

	@Override
	/** 즐겨찾기 삭제하기 */
	public void remove(Long favoritesNum) {

		favoritesRepository.deleteById(favoritesNum);
	}

	@Override
	public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
