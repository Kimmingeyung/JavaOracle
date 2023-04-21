package com.oraclejava.tour;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyContoller {
	
	@RequestMapping("/")
	public ModelAndView handleTop(ModelAndView mav) {
		mav.addObject("mymessage","Hello");
		mav.setViewName("myview");
		return mav;
	}
}
