<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SessionScope</h2>
	<%
		//sessionScope :session은 내장객체
		session.setAttribute("email", "hong@gmail.com");
		//requestScope
		request.setAttribute("email", "hong@gmail.com");
	%>
	<h3>jsp표현식</h3>
	이메일 : <%=session.getAttribute("email") %> <br>
	<h3>EL</h3>
	이메일 : ${sessionScope.email } <br>
	<h3>EL(생략가능)</h3>
	<!-- requestScope가 sessionScope보다 우선 -->
	<!-- requestScope와 이름이 겹칠 때 requestScope먼저 가져옴 -->
	이메일 : ${email } <br>
	
</body>
</html>