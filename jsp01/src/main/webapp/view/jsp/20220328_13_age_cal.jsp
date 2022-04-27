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
		//성인, 미성년자 체크
		int age = Integer.parseInt(request.getParameter("age"));
		String agetype; //초기화가 없으면 쓰레기값
		if(age>=20){
			agetype="성인";
		}else {
			agetype="미성년자";
		}
		//값 담기
		request.setAttribute("age", age);
		request.setAttribute("agetype", agetype);
		//결과창으로 이동
		request.getRequestDispatcher("20220328_13_result.jsp").forward(request, response);
	
	%>
</body>
</html>