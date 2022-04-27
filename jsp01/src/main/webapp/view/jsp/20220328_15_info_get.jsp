<%@page import="java.net.URLEncoder"%>
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
		//msg ; 계열 메세지
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String prefix = major.substring(0,1);
		System.out.println(prefix);
		//만약에 prefix가 'a'라면 공학계열
		//'b'라면 자연계열
		String result=null;
		if(prefix.equals("a")){
			result="공학계열";
		}else if(prefix.equals("b")){
			result="자연계열";
		}
		//redirect이동
		//자바의 인코딩과 url인코딩이 다르다
		name = URLEncoder.encode(name, "utf-8");
		result = URLEncoder.encode(result, "utf-8");
		response.sendRedirect("20220328_result.jsp?name="+name+"&result="+result);
	
	%>
</body>
</html>