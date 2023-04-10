package com.oraclejava.project.web;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.project.dao.MovieDAO;
import com.oraclejava.project.dao.MovieDAOImpl;
import com.oraclejava.project.dao.OracledbConnection;
import com.oraclejava.project.dto.Movie;


@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String action = req.getParameter("action");
		if(action==null) {
			action="list"; // �⺻ �׼� list
		}
		switch(action){
		
		case "write":
			writeMovie(req,resp);
			break;
		
		case "list":
			listMovie(req, resp);
			break;
			
		case "search":
			searchMovie(req,resp);
			break;	
			
		case "detail":
			detailMovie(req,resp);
			break;		
			
		}
		
	}
	
	private void detailMovie(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		MovieDAO movieDAO = new MovieDAOImpl();
		
		int id = Integer.parseInt(req.getParameter("id"));
		Movie movie = movieDAO.detailMovie(id);
		req.setAttribute("movie", movie);
		req.getRequestDispatcher("/WEB-INF/veiw/detail.jsp").forward(req, resp);
		
		
	}

	private void searchMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		MovieDAO movieDAO = new MovieDAOImpl();
		
		String title = req.getParameter("title"); // �˻��� ��ȭ���� �޾ƿ�
		System.out.println(title);
	 	List<Movie> movieList = movieDAO.searchMovie(title); // jsp���� ����� ��ü�Ӽ�  
	 	
	 	//Model2������� ���Һд�  : ��Ʈ�ѷ��� �� �и�
	 	req.setAttribute("movieList", movieList); 
	 	//path: webapp�� ���� 
	 	req.getRequestDispatcher("/WEB-INF/veiw/movie.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action==null) {
			action="list"; // �⺻ �׼� list
		}
		switch(action){
		
		case "write":
			createMovie(req,resp);
			break;
		
		case "list":
			listMovie(req, resp);
			break;
			
		case "update":
			updateMovie(req, resp);
			break;
			
		}
	}
	
	
	
	private void updateMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		if(req.getParameter("update") !=null) {
			
			MovieDAO movieDAO = new MovieDAOImpl();
			Movie movie = new Movie();
			movie.setMovie_id(Integer.parseInt(req.getParameter("movie_id")));
			movie.setTitle(req.getParameter("title"));
			movie.setPrice(Integer.parseInt(req.getParameter("price")));
			movie.setSynopsis(req.getParameter("synopsis"));
			movieDAO.updateMovie(movie);
			
		} else if (req.getParameter("delete") != null) {

			MovieDAO movieDAO = new MovieDAOImpl();
			movieDAO.deleteMovie(Integer.parseInt(req.getParameter("movie_id")));
		}
		
		
		
		
		
		
		resp.sendRedirect("/movie/MovieServlet");
		
	}
	private void createMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		MovieDAO movieDAO = new MovieDAOImpl();
		
		Movie movie = new Movie();
		movie.setTitle(req.getParameter("title"));
		movie.setPrice(Integer.parseInt(req.getParameter("price")));
		movieDAO.insertMovie(movie);
		resp.sendRedirect("/movie/MovieServlet");
		
	}
	
	private void writeMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/veiw/write.jsp").forward(req, resp);
	}
	
	
	private void listMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html;charset=utf-8");
		
		MovieDAO movieDAO = new MovieDAOImpl();
	 	List<Movie> movieList = movieDAO.selectMovieAll(); // jsp���� ����� ��ü�Ӽ�  
	 	
	 	//Model2������� ���Һд�  : ��Ʈ�ѷ��� �� �и�
	 	req.setAttribute("movieList", movieList); 
	 	//path: webapp�� ���� 
	 	req.getRequestDispatcher("/WEB-INF/veiw/movie.jsp").forward(req, resp);
	 	
	}
	
	

	
}
