package com.keduit.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.helloworld.entity.Tetris;

public interface TetrisRepository extends JpaRepository<Tetris, Long>{

	/** 3명 가져오기 */
	@Query(value = "select * from tetris t join member m on t.member_num = m.member_num order by score desc limit 3" ,nativeQuery=true)
	List<Tetris> max3();

	
}
