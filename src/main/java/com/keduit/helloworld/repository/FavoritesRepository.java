package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.Favorites;

@Repository

public interface FavoritesRepository extends JpaRepository<Favorites, Integer>{

	
	@Query(value = "select f.favorites_num, m.id from Favorites as f inner join Member as m " 
			+ "on m.member_num = f.bookmarked where f.bookmarker= :bookmarker", nativeQuery = true)
	List<Favorites> getFavoritesMarker(Integer bookmarker);
	
	@Query(value = "select * from Favorites join Member on favorites_num = Member.member_num where bookmarker = :marker ", nativeQuery = true)
	List<Favorites> getMarker(Integer marker);
	
}
