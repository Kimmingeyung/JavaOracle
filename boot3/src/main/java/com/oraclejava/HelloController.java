package com.oraclejava;

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
public class HelloController {

	//상수 : private static final int 
	private static final int PAGE_SIZE = 5;  
	
	@Autowired // 가장 중요한 구문 
	private MovieRepository movieRepository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index( @RequestParam(required = false, value="page")Integer pageNumber) {
		
		pageNumber = (pageNumber == null) ? 1: pageNumber;
		
		ModelAndView mvn = new ModelAndView();
		mvn.setViewName("index");
		mvn.addObject("msg1", "hi!");
		// select * from movie와 같다.
//		mvn.addObject("movielist", movieRepository.findAll(Sort.by("title").ascending()));
		//가격이 높은 순으로 정렬
		//mvn.addObject("movielist", movieRepository.findAll(Sort.by("price").ascending()));
		//영화 id순으로 정렬
		//mvn.addObject("movielist", movieRepository.findAll(Sort.by("movieId").descending().and(Sort.by("price"))));
		
		Page<Movie> movies = movieRepository.findAll(PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.by("movieId")));
		
		int current = movies.getNumber() + 1;
		int begin = 1;
		int end = movies.getTotalPages();
		
		
		mvn.addObject("movielist",movies);
		mvn.addObject("beginIndex", begin);
		mvn.addObject("endIndex", end);
		mvn.addObject("currentIndex", current);
		
		return mvn;
		
		
	}
	
}
