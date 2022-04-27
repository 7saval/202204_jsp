<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL표현언어</h2>
	<%=10+20%> <br>
	덧셈 : ${10+20 } <br>
	뺄셈 : ${10-20 } <br>
	곱셈 : ${10*20 } <br>
	나눗셈 : ${10/20 } <br>
	나머지 : ${10%3 } <br>
	나머지 : ${10 mod 3} <br>
	<hr>
	${10==10} <br>
	${10 eq 10} <br>
	
	<%
		pageContext.setAttribute("title", "EL테스트");
	
	%>
	${title != null} <br>
	${empty title}
	
	<hr>
	${20>10?"크다":"작다"}
	
</body>
</html>