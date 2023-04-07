<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>

<%--get-한글깨짐 jsp 인코딩언어 설정해야함!!! --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 등록</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<h2>영화 정보 등록</h2>
	<form method="post" action="">
		<input type="hidden" name="action" value="write">
		<table>
			<tr><td>영화명</td><td><input type="text" name="title"></td></tr>
			<tr><td>가격</td><td><input type="number" name="price"></td></tr>
			<tr><td colspan="2"></td><td><input type="submit" name="확인"></td></tr>
		</table>
	</form> 
	
</body>
</html>