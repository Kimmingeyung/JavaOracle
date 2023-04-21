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
	public List<TourInfo> findTourByCriteria(TourInfoCriteria criteria) {
		// 쿼리 작성
		// DB에 매핑되는 자바파일에 있는 클래스명/ 제대로 입력하면 링크됨
		String jpql = "SELECT t FROM TourInfo t ";
		jpql += "WHERE 1=1"; // 조건 추가시에 사용하는 방법
		
		//여행 이름
		if (criteria.getTourName() != null) {
			//jpql += " WHERE t.tourName LIKE :tourName ESCAPE '%'";
			jpql += " AND t.tourName LIKE :tourName ESCAPE '\\'";
		}
		
		//여행 기간
		if(criteria.getDepDay()!=null) {
			jpql += "AND t.tourDays = :tourDays";
		}
		
		//출발 일
		if (criteria.getDepStartDay() != null &&
								criteria.getDepEndDay()!=null) {
				jpql += "AND t.depDay BETWEEN :depStartDay AND :depEndDay ";
		}
		
		//가격
		if(criteria.getBaseStartPrice()!= null &&
				criteria.getBaseEndPrice()!=null) {
			jpql += "AND t.basePrice BETWEEN :baseStartPrice AND :baseEndPrice ";
		}
		
		jpql += " ORDER BY t.depDay "; // 출발일자 순으로 정렬
		
		//System.out.println(jpql);
		//jpql += " ORDER BY t.depDay DES"; // 내림차순 정렬
		
		
		TypedQuery<TourInfo> query = em.createQuery(jpql, TourInfo.class);
		if(criteria.getTourName() != null) {
					String name = criteria.getTourName().replace("_", "\\_)");
					name = name.replace("%", "\\%");
					// 입력값을 criteria로 받아서 명령문을 구성하게 됨 
					query.setParameter("tourName","%"+name+"%" );
		}

		 	
		// 여행 기간
		if (criteria.getTourDays() != null) {
			query.setParameter("tourDays", criteria.getTourDays());
		}
		
		// 출발 일
		if (criteria.getDepStartDay()!=null &&
				criteria.getDepEndDay() != null) {
					query.setParameter("depStartDay", criteria.getDepStartDay());
					query.setParameter("depEndDay", criteria.getDepEndDay());
			
		}
		
		// 가격 
		if (criteria.getBaseStartPrice()!= null &&
				criteria.getBaseEndPrice()!= null) {
				query.setParameter("baseStartPrice", criteria.getBaseStartPrice());
				query.setParameter("baseEndPrice", criteria.getBaseEndPrice());
		}
		
		List<TourInfo> tourInfoList = query.getResultList(); // 목록일 때 
		
		return tourInfoList;
	}
	
}
