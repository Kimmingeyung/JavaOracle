package com.oraclejava.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.tour.model.Customer;

public interface CustomerRepository 
	extends JpaRepository<Customer, Integer>{

}
