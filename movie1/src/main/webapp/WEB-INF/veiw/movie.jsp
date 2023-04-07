
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%@ page import = "java.util.*" %>  2�� 
<%@ page import="com.oraclejava.project.dao.*,com.oraclejava.project.dto.*" %>     2--%>
<%-- 
<%   1�� 
 	MovieDAO movieDAO = new MovieDAOImpl();// movieDAO�� �������̽��̱� ������ ��ü�� ������ �� ����
 	List<Movie> movieList = movieDAO.selectMovieAll();
 	
%>
    --%> 
    
<%-- <%
	List<Movie> movieList = (List<Movie>)request.getAttribute("movieList");
%>    
     2--%>
     
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>movie ���</title>
<link rel="stylesheet" href="main.css">
</head>
<body>

<%-- 	<h2>��ȭ���</h2>
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
	 --%>
	 
	 <h2>��ȭ���</h2>
	 ��ϵ� ��ȭ��: ${fn:length(movieList)}��
	 <br><br>
	 <div id="movieList">
	 <c:forEach var="m" items="${movieList}">
	 	<div style="margin:5px">
	 		��ȭ��:${m.title} <br>
	 		����: ${m.price}
	 	</div>
	 </c:forEach>
	 </div>
	 
	 
</body>
</html>