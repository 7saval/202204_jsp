<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>List 출력</h2>
	<%
		List<String> list = new ArrayList<>();
		list.add("자바");
		list.add("파이썬");
		list.add("오라클");
		request.setAttribute("list", list);
	%>
	<h2>List 출력(jstl+el)</h2>
	<c:forEach var="lang" items="${list}" varStatus="status">
		${status.count}. ${lang} <br>
	</c:forEach>
</body>
</html>