package com.oraclejava.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.tour.model.Accommodation;

public interface AccomodationRepository 
	extends JpaRepository<Accommodation, Integer>{

}
