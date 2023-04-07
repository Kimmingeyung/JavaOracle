<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세화면</title>
</head>
<body>
	<img src ="/movie/images/${movie.movie_id}.PNG" alt="${movie.title}사진" width="100px"><br>
	<table>
		<tbody>
		    
			<tr><td>영화명</td><td><input type="text" name="title" value="${movie.title}"></td><td></td></tr>
			<tr><td>가격</td><td><input type="text" name="price" value="${movie.price}"></td><td></td></tr>
			<tr><td>시놉시스</td><td><textarea rows="5" cols="60">${movie.synopsis}</textarea></td><td></td></tr>
		</tbody>
		
	</table>
</body>
</html>