package com.oraclejava.tour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.tour.model.Customer;
import com.oraclejava.tour.repository.CustomerRepository;

@Transactional
@Service
public class CustomerServiceImpl 
	implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer findOne(int customerCode) {
		return customerRepository.findById(customerCode).orElse(null);
	}

	@Override
	public Customer register(Customer customer) {
		//TODO: 추후 비번 암호화 추가
		return customerRepository.save(customer);
	}

	
}
