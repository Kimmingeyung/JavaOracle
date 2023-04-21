package com.oraclejava.tour.repository;

import java.util.List;

import com.oraclejava.tour.model.TourInfo;


public interface TourInfoCustom {
	List<TourInfo> findTourByCriteria(TourInfoCriteria criteria);
}
