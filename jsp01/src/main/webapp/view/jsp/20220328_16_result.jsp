<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과창</h2>
	<!-- 홍길동은 공학계열입니다. -->
	
	<%= request.getParameter("name") %>은 <%= request.getParameter("result") %>입니다.
</body>
</html>