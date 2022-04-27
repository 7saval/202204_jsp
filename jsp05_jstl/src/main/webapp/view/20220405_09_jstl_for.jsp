<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp반복문</h2>
	<%
		for(int i=0;i<10;i++){
	%>		
		<%=i%>
	<%	}
	%>
	<h2>jstl 반복문</h2>
	<c:forEach var="i" begin="0" end="9" step="1" >
		${i}
	</c:forEach>
	
	<h2>2단 구구단</h2>
		<2단> <br>
	<c:forEach var="i" begin="1" end="9" step="1">	
		2*${i} = ${2*i } <br>
	</c:forEach>
	<hr>
	<h2>구구단</h2>
	<c:forEach var="j" begin="2" end="9" step="1">
		<${j}단> <br>
		<c:forEach var="i" begin="1" end="9" step="1">	
			${j}*${i} = ${j*i } <br>
		</c:forEach> <br>
	</c:forEach>
		
	
	
	
	
</body>
</html>