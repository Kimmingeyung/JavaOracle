package com.oraclejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	private static final int PAGE_SIZE = 5;
	
	
	@Autowired
	private CustomerRepository tourRepository;
	
	
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ModelAndView customers( @RequestParam(required=false, value="page")Integer pageNumber) {
		// TODO Auto-generated method stub
		pageNumber = (pageNumber==null)? 1: pageNumber;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customers");

		Page<Customer> customer = tourRepository.findAll(PageRequest.of(pageNumber-1, PAGE_SIZE, Sort.by("customerCode")));
		
		int current = customer.getNumber() + 1;
		int begin = 1;
		int end = customer.getTotalPages();

		mav.addObject("customerList",customer);
		mav.addObject("currentIndex",current);
		mav.addObject("beginIndex",begin);
		mav.addObject("endIndex",end);
		
		return mav;
	}
	

}
