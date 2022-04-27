<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Member> mlist = new ArrayList<>();
		mlist.add(new Member("java","1111","김자바","java@gmail.com"));
		mlist.add(new Member("hong","2111","홍길동","hong@gmail.com"));
		request.setAttribute("mlist", mlist);
	%>
	<%-- <%=mlist %> --%>
	
	<h2>EL(dto의 list)</h2>
	<!-- requestScope범위에 담긴 변수 -->
	${mlist}
	<hr>
	<h2>jstl</h2>
		<table border="1">
			<thead>
				<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			</thead>
			<tbody>
				<!-- 변수에는 풀어졌을 때 형 -->
				<c:forEach var="member" items="${mlist}">
					<tr>
						<td>${member.userid}</td>
						<td>${member.passwd}</td>
						<td>${member.name}</td>
						<td>${member.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>