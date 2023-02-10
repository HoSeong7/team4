package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keduit.helloworld.entity.Favorites;
import com.keduit.helloworld.entity.Member;

@Repository

public interface FavoritesRepository extends JpaRepository<Favorites, Long>{


	
}
