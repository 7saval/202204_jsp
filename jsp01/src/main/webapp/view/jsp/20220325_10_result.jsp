<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 결과창</h2>
	<%
		//post방식일 경우 인코딩 utf-8
		request.setCharacterEncoding("utf-8");
		String userid= request.getParameter("userid");
		String passwd= request.getParameter("passwd");
		String email= request.getParameter("email");
		String name= request.getParameter("name");
		String gender= request.getParameter("gender");
		String way= request.getParameter("way");
		//타임은 체크박스 여러개이므로 배열로 반환하는 getParametervalues써야 함
		String[] times= request.getParameterValues("time");	
	%>
	<hr>
	아이디: <%=userid %> <br>
	이메일: <%=email %> <br>
	이름: <%=name %> <br>
	성별: <%=gender %> <br>
	가입경로: <%=way %> <br>
	
	가능시간: 
	<%
		for(String time:times){
	%>
			<%=time %>
	<%
		}
	%>
	
</body>
</html>