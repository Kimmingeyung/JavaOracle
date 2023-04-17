package com.oraclejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin/customers")
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
		//mav.setViewName("customers");
		mav.setViewName("homeLayout");
		mav.addObject("contents","adminHome::admin_contents");
		mav.addObject("admin_contents","customers::admin_contents");

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
		
		customer.setRole("ROLE_USER"); // 기본 권한 부여
		
		tourRepository.save(customer);
		return "redirect:/admin/customers/";
	}
	
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Customer customer = tourRepository.findById(id).get();
		model.addAttribute("customer", customer);
		return "customerUpdate";
	}
	
	
	@RequestMapping(params="update",value="/update/{customerCode}", method=RequestMethod.POST)
	public String update(Customer customer, Model model) {
		
		Customer scustomer = tourRepository.findById(customer.getCustomerCode()).get();
		scustomer.setCustomerName(customer.getCustomerName());
		String oldPassword = scustomer.getCustomerPass();
		String newPassword = customer.getCustomerPass();
		
		if (!newPassword.equals(oldPassword)) { // != 안됨
			customer.setCustomerPass(passwordEncoder.encode(newPassword));
		}
		
		//scustomer.setCustomerBirth(customer.getCustomerBirth());
		scustomer.setCustomerPass(customer.getCustomerPass());
		scustomer.setCustomerJob(customer.getCustomerJob());
		scustomer.setCustomerTel(customer.getCustomerTel());
		scustomer.setCustomerMail(customer.getCustomerMail());
		scustomer.setCustomerPost(customer.getCustomerPost());
		scustomer.setCustomerAdd(customer.getCustomerAdd());
	
		tourRepository.save(scustomer); // 업데이트
		
		return "redirect:/admin/customers";
	}
	
	
	//고객삭제
	@RequestMapping(params="delete", value="/update/{customerCode}", method=RequestMethod.POST)
	public String delete(@PathVariable Integer customerCode, Model model) {
		Customer scustomer = tourRepository.findById(customerCode).get();
		tourRepository.delete(scustomer);
		return "redirect:/admin/customers";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
