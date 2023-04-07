package com.oraclejava.project.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.project.dao.MovieDAO;
import com.oraclejava.project.dao.MovieDAOImpl;
import com.oraclejava.project.dto.Movie;


@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html;charset=utf-8");
		
		MovieDAO movieDAO = new MovieDAOImpl();
	 	List<Movie> movieList = movieDAO.selectMovieAll();
	 	
	 	//Model2������� ���Һд�  : ��Ʈ�ѷ��� �� �и�
	 	req.setAttribute("movieList", movieList); 
	 	//path: webapp�� ���� 
	 	req.getRequestDispatcher("/WEB-INF/veiw/movie.jsp").forward(req, resp);  
		
	}
	
	private void listMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html;charset=utf-8");
		
		MovieDAO movieDAO = new MovieDAOImpl();
	 	List<Movie> movieList = movieDAO.selectMovieAll();
	 	
	 	//Model2������� ���Һд�  : ��Ʈ�ѷ��� �� �и�
	 	req.setAttribute("movieList", movieList); 
	 	//path: webapp�� ���� 
	 	req.getRequestDispatcher("/WEB-INF/veiw/movie.jsp").forward(req, resp);  
		
	}
	
}
