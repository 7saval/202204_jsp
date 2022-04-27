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
	<!-- 당신은 살입니다
	성인입니다 -->
	<%
		String agetype = (String)request.getAttribute("agetype");
		int age = (int)request.getAttribute("age");
	%>
	당신은 <%=age %>살입니다. <br>
	<%=agetype %>입니다.
</body>
</html>