package com.oraclejava.tour.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;
import com.oraclejava.tour.service.TourInforService;

@RequestMapping(value="/tours")
@Controller
public class SearhTourController {
	
	@Autowired
	private TourInforService tourInfoService;
	
	@RequestMapping(method=RequestMethod.GET)
	private String searchAll(
			@RequestParam(required=false, value="tourName")
			String tourName,
			@RequestParam(required=false, value="tourDays")
			String tourDays,
			@RequestParam(required=false, value="depStartDay")
			String depStartDay,
			@RequestParam(required=false, value="depEndDay")
			String depEndDay,
			@RequestParam(required=false, value="baseStartPrice")
			Integer baseStartPrice,
			@RequestParam(required=false, value="baseEndPrice")
			Integer baseEndPrice,
			Model model) throws ParseException {
	
		TourInfoCriteria criteria = new TourInfoCriteria();
		criteria.setTourName(tourName);
		criteria.setTourName(tourDays);
		criteria.setBaseStartPrice(baseStartPrice);
		criteria.setBaseEndPrice(baseEndPrice);
		
		//System.out.println(depStartDay);
		//System.out.println(depEndDay);
		
		//포맷터 - 임포트 : 자바
		SimpleDateFormat formatter = 
				new SimpleDateFormat("yyyy-MM-dd");
		
		//물자열 빈값 처리
		//StringUtils (스프링 부트에 포함되어 있는 라이브러리: 아파치 톰캣에 포함된 라이브러리나 스프링에 포함
		
		//isEmpty()가 thymeleaf 유틸로 처리되어야함
		if(!StringUtils.isEmpty(depStartDay)
				&& !StringUtils.isEmpty(depEndDay)) {
			// 에러를 ParseException으로 처리할 것 !
			criteria.setDepStartDay(formatter.parse(depStartDay)); 
			criteria.setDepEndDay(formatter.parse(depEndDay));
			
		}
		
		
		
		List<TourInfo> tours = tourInfoService.searchTour(criteria);
		model.addAttribute("tours", tours);
		
		//검색값 유지
		model.addAttribute("tourName", tourName);
		model.addAttribute("tourDays", tourDays);
		model.addAttribute("depStartDay", depStartDay);
		model.addAttribute("depEndDay", depEndDay);
		
		model.addAttribute("baseStartPrice", baseStartPrice);
		model.addAttribute("baseEndPrice", baseEndPrice);
		
		return "searchTour";
	}
	
	
}
