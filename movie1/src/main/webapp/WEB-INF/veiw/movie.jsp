
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%@ page import = "java.util.*" %>  2번 
<%@ page import="com.oraclejava.project.dao.*,com.oraclejava.project.dto.*" %>     2--%>
<%-- 
<%   1번 
 	MovieDAO movieDAO = new MovieDAOImpl();// movieDAO는 인터페이스이기 때문에 객체를 생성할 수 없음
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
<title>movie 목록</title>
<link rel="stylesheet" href="main.css">
</head>
<body>

<%-- 	<h2>영화목록</h2>
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
	 --%>
	 
	 <h2>영화목록</h2>
	 등록된 영화수: ${fn:length(movieList)}편
	 <br><br>
	 <div id="movieList">
	 <c:forEach var="m" items="${movieList}">
	 	<div style="margin:5px">
	 		영화명:${m.title} <br>
	 		가격: ${m.price}
	 	</div>
	 </c:forEach>
	 </div>
	 
	 
</body>
</html>