package com.oraclejava.Config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView Login(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPage");
		return mav;
	}
	
	
	
}
