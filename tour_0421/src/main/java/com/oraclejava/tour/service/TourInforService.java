/*
 * 전체 여행목록출력을 사용할 가능성이 없기 때문에 안쓸 예정 
 * */

package com.oraclejava.tour.service;

import java.util.List;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;

public interface TourInforService {

	//모든 여행 정보 불러오기 (안쓸 예정)
	List<TourInfo> searchTourAll();
	
	// 여행 정보 검색
	List<TourInfo> searchTour(TourInfoCriteria criteria);
	

}
