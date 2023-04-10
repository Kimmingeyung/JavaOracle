
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>영화목록</title>
<link rel="stylesheet" href="main.css">
</head>

<body>	 
	 <h2>영화목록</h2>
	 
	 <form method="get" action="">
	 	<input type="hidden" name="action" value="search">
	 	영화제목: <input type="text" name="title"/>
	 	<input type="submit" value="조회"/>
	 </form>
	 
	 <br><br>
	 
	 <!-- 링크 주소 적을 때 주의할 것 
	 	1. 포트 번호는 로컬에서만 사용할 수 있기 때문에 생략하고 적을 것!
	 	2. 스펠링 : 주소지를 정확하게 적기!!!!
	 --> 
	 <a href="/movie/MovieServlet?action=write">영화등록</a> 
	 등록된 영화수: ${fn:length(movieList)}편
	 <br><br>
	 <div id="movieList">
	 <c:forEach var="m" items="${movieList}">
	 	<div style="margin:5px">
	 	<a href="/movie/MovieServlet?action=detail&id=${m.movie_id}">
	 	<!-- http://localhost:8090/movie/movieServlet?action=detail&id=${m.movie_id} -->
	 		 <!-- 이미지 확장자는하나로통일할것 -->
	 		<img src ="/movie/images/${m.movie_id}.PNG" alt="${m.title}사진" width="100px"><br>
	 		영화명:${m.title} <br>
	 		가격: ${m.price}
	 	</a>
	 	</div>
	 </c:forEach>
	 </div>
	 
	 
</body>
</html>