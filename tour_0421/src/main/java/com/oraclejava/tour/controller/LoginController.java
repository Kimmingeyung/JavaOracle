package com.oraclejava.tour.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "loginPage";
	}
}

