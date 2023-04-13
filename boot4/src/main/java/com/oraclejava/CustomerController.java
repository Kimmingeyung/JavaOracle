package com.oraclejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {

	private static final int PAGE_SIZE = 5;
	
	@Autowired
	private CustomerRepository tourRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder; // 의존성 주입 - pw 인코더
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public ModelAndView customers( @RequestParam(required=false, value="page")Integer pageNumber) {
		// TODO Auto-generated method stub
		pageNumber = (pageNumber==null)? 1: pageNumber;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customers");

		Page<Customer> customer = tourRepository.findAll(PageRequest.of(pageNumber-1, PAGE_SIZE, Sort.by("customerCode")));
		
		int current = customer.getNumber() + 1;
		int begin = 1;
		int end = customer.getTotalPages();

		mav.addObject("customerList", customer);
		mav.addObject("currentIndex", current);
		mav.addObject("beginIndex", begin);
		mav.addObject("endIndex", end);
		
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {
		return "customerCreate";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Model model, Customer customer) {
	
		String pass = customer.getCustomerPass(); // pw를 받아와서
		customer.setCustomerPass(passwordEncoder.encode(pass)); //인코더기에 넣어서 값출력
		
		tourRepository.save(customer);
		return "redirect:/customers/";
	}
	
	
}
