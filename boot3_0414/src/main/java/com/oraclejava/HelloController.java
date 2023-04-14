package com.oraclejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/cgv")
public class HelloController {

	//상수 : private static final int 
	private static final int PAGE_SIZE = 10;  
	
	@Autowired // 가장 중요한 구문 
	private MovieRepository movieRepository;
	
	@RequestMapping(value={"/" ,""},method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(required = false, value="page")Integer pageNumber) {
		
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
	
	
	//영화 추가 화면
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {	
		return "movieCreate";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(Movie movie , Model model) {
		
		movieRepository.save(movie);
		return "redirect:/cgv/";
	}
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Movie movie = movieRepository.findById(id).get();
		model.addAttribute("movie",movie); //th:obejct와 매핑됨
		return "movieUpdate";
		
	}
	
	// 수 정 http://localhost:8090/cgv/update/1?
	@RequestMapping(params={"update"}, value="/update/{movieId}", method=RequestMethod.POST)
	public String update(Movie movie, Model model){
		//smoive: 찾은 영화(search Movie)
		Movie smovie = movieRepository.findById(movie.getMovieId()).get();

		smovie.setTitle(movie.getTitle());
		smovie.setPrice(movie.getPrice());
		smovie.setSynopsis(movie.getSynopsis());
		movieRepository.save(smovie);
		
		return "redirect:/cgv"; // 수정하고 back!
	}
	
	
	//삭제
	@RequestMapping(params={"delete"}, value="/update/{movieId}", method= RequestMethod.POST)
	public String delete(@PathVariable Integer movieId, Model model) {
		Movie smovie = movieRepository.findById(movieId).get();
		movieRepository.delete(smovie);
		return "redirect:/cgv";		
		
	}

	
	
	
}
