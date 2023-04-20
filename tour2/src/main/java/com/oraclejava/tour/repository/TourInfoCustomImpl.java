package com.oraclejava.tour.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.tour.model.TourInfo;

public class TourInfoCustomImpl implements TourInfoCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<TourInfo> findToursByCriteria(TourInfoCriteria criteria) {
		// 쿼리 작성
		String jpql = "SELECT t FROM TourInfo t "; 
		jpql += "WHERE 1=1"; // 조건추가시에 사용하는 방법
		
		if (criteria.getTourName() != null) {
			//jpql += " WHERE t.tourName LIKE :tourName ESCAPE '\\' ";
			jpql += " AND t.tourName LIKE :tourName ESCAPE '\\' ";
		}
		//여행 기간
		if(criteria.getTourDays() != null) {
			jpql += " AND t.tourDays = :tourDays";
		}
		
		jpql += " ORDER BY t.depDay "; // 출발일자 순으로 정렬
		
		TypedQuery<TourInfo> query = em.createQuery(jpql, TourInfo.class);
		if (criteria.getTourName() != null) {
			String name = criteria.getTourName().replace("_", "\\_");
			name = name.replace("%", "\\%");
			query.setParameter("tourName","%" + name + "%");
					/*"%" + criteria.getTourName() + "%");*/
		}
		
		// 여행 기간
		if (criteria.getTourDays() != null) {
			query.setParameter("tourDays", criteria.getTourDays());
		}
		
		List<TourInfo> tourInfoList = query.getResultList();
		
		return tourInfoList;
	}

}







