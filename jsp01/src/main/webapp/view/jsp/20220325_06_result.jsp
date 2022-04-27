<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사각형의 넓이 결과창</h2>
	<%	
		//래퍼클래스를 이용한 형변환:문자열=>정수(참조형->기본형)
		int width = Integer.parseInt(request.getParameter("width"));
		int height = Integer.parseInt(request.getParameter("height"));
		//같은 형끼리만
		/* int width = (int)request.getParameter("width");
		int height = (int)request.getParameter("height"); */
	%>
	사각형의 넓이 : <%=width*height%>
</body>
</html>