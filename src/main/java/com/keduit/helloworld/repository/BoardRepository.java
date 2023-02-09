package com.keduit.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keduit.helloworld.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
