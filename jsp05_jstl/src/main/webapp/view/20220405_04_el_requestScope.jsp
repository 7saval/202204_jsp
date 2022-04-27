<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* request 범위 */
		request.setAttribute("name", "홍길동");
		request.setAttribute("age", 20);
	
	%>
	<h2>jsp표현식</h2>
	이름 : <%=request.getAttribute("name") %> <br>
	나이 : <%=request.getAttribute("age") %>
	<h2>EL</h2>
	이름 : ${requestScope.name } <br>
	나이 : ${requestScope.age } <br>
	<h2>EL(생략가능)</h2>
	이름 : ${name } <br>
	나이 : ${age }<br>
	
</body>
</html>