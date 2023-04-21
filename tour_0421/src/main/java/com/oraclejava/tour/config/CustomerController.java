package com.oraclejava.tour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oraclejava.tour.model.Customer;
import com.oraclejava.tour.service.CustomerServcie;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {

	@Autowired
	private CustomerServcie customerService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createFrom(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "createCustomerForm";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Customer customer) {
		
		customer.setRole("ROLE_USER");
		customerService.register(customer);   // register하면 save가 됨 
		return "redirect:/login";
	}
	
	
	
	
}
