<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name = "��ΰ�";
	int numInt = 202005005;
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--html �±��ּ� -->
	<%--jsp �ּ� --%>
	<h1>�й�: <%= numInt %></h1>
	<h1>�̸�: <%= name%></h1>
	<%@ include file="hello2b.jsp" %>
	
    	
</body>
</html>