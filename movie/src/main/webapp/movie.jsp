<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "java.util.*" %>
<%@ page import="com.oraclejava.project.dao.*,com.oraclejava.project.dto.*" %>    

<%
 	MovieDAO movieDAO = new MovieDAOImpl();// movieDAO는 인터페이스이기 때문에 객체를 생성할 수 없음
 	List<Movie> movieList = movieDAO.selectMovieAll();
 	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>movie 목록</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<h2>영화목록</h2>
	등록된 영화수: <%= movieList.size() %>
	<br/><br/>
	<div id="movieList">
	<%
		for (Movie m : movieList){
	%>
		<div style="margin:5px">
			영화면: <%= m.getTitle() %> <br/>
			가격: <%= m.getPrice() %> 원 
		</div>
	<%
		}
	%>	
		
	</div>
	
</body>
</html>