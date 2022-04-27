<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<section>
	<!-- 회원조회 -->
	<h2>회원목록조회/수정</h2>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
			List<Member> mlist= (List<Member>)request.getAttribute("mlist");
			if(mlist != null){
				for(Member member:mlist){
			%>
			<tr>
				<td><a href="/jsp03_hrd/member/modiform?custno=<%=member.getCustno()%>"><%=member.getCustno()%></a></td>
				<td><%=member.getCustname()%> </td>
				<td><%=member.getPhone()%></td>
				<td><%=member.getAddress()%></td>
				<td><%=member.getJoindate()%></td>
				<td><%=member.getGrade()%></td>
				<td><%=member.getCity()%></td>
			</tr>
		
		<% 		
				}
			}
		%>		
		</table>
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>