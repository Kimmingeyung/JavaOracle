package com.oraclejava.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oraclejava.Customer;
import com.oraclejava.CustomerRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Customer customer = customerRepository.findByCustomerMail(email);
		
		UserDetails user = 
				new User(email, customer.getCustomerPass(),
						AuthorityUtils.createAuthorityList(customer.getRole()));
		return user;
		
	}
}
