package com.oraclejava;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findAll(Sort sort);
	
	Page<Customer> findAll(Pageable pageable);
}
