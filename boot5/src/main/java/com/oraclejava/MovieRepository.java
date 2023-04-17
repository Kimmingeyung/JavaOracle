package com.oraclejava;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	//정렬
	List<Movie> findAll(Sort sort);
	
	//페이징
	Page<Movie> findAll(Pageable pageable);
	
	
}
