package com.oraclejava.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;
import com.oraclejava.tour.service.TourInfoService;

@Controller
@RequestMapping(value = "/tours")
public class SearchTourController {

	@Autowired
	private TourInfoService tourInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchAll(
			@RequestParam(required = false, value = "tourName")
			String tourName,
			@RequestParam(required = false, value = "tourDays")
			Integer tourDays,
			Model model) {
		
		TourInfoCriteria criteria = new TourInfoCriteria();
		criteria.setTourName(tourName);
		criteria.setTourDays(tourDays);
		
//		List<TourInfo> tours = tourInfoService.searchTourAll();
		List<TourInfo> tours = tourInfoService.searchTour(criteria);
		model.addAttribute("tours", tours);
		model.addAttribute("tourName", tourName);
		model.addAttribute("tourDays", tourDays);
		
		return "searchTour";
	}
}
