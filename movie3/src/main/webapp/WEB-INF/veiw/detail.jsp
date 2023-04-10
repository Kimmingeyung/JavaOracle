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
	<form method="post" action="/movie/MovieServlet"/>
		<input type="hidden" name="action" value="update"/>
		<input type="hidden" name="movie_id" value="${movie.movie_id}"/>
		<table>
			<tbody>
			  
				<tr>
					<td>영화명</td><td><input type="text" name="title" value="${movie.title}"></td><td></td>
				</tr>
				<tr>
					<td>가격</td><td><input type="text" name="price" value="${movie.price}"></td><td></td>
				</tr>
				<tr>
					<td>줄거리</td><td><textarea rows="5" name="synopsis" cols="60">${movie.synopsis}</textarea></td><td></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" name="update"/>
						<input type="submit" value="삭제" name="delete"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>