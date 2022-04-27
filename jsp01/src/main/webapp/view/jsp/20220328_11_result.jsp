<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward 결과창</h2>
	<%
		//request객체의 정보 읽기
		String name = (String)request.getAttribute("name");
		int age = (int)request.getAttribute("age");
	
	%>
	이름 : <%=name%> <br>
	나이 : <%=age%>
</body>
</html>