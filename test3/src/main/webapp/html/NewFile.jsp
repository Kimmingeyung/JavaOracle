<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name = "김민경";
	int numInt = 202005005;
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--html 태그주석 -->
	<%--jsp 주석 --%>
	<h1>학번: <%= numInt %></h1>
	<h1>이름: <%= name%></h1>
	<%@ include file="hello2b.jsp" %>
	
    	
</body>
</html>