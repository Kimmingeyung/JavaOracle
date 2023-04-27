package com.oraclejava.react.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class MovieController {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView movie(Model model) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("message","영화 소개입니다.");		
		return mav;
	}	
	
}
