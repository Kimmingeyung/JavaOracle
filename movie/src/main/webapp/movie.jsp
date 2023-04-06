<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import = "java.util.*" %>
<%@ page import="com.oraclejava.project.dao.*,com.oraclejava.project.dto.*" %>    

<%
 	MovieDAO movieDAO = new MovieDAOImpl();// movieDAO�� �������̽��̱� ������ ��ü�� ������ �� ����
 	List<Movie> movieList = movieDAO.selectMovieAll();
 	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>movie ���</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<h2>��ȭ���</h2>
	��ϵ� ��ȭ��: <%= movieList.size() %>
	<br/><br/>
	<div id="movieList">
	<%
		for (Movie m : movieList){
	%>
		<div style="margin:5px">
			��ȭ��: <%= m.getTitle() %> <br/>
			����: <%= m.getPrice() %> �� 
		</div>
	<%
		}
	%>	
		
	</div>
	
</body>
</html>