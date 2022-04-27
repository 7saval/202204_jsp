<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<h2>회원조회</h2>
		<%-- ${mlist} --%>
		
		<form action="${path}/list.member">
			<select name="findkey">
				<option value="userid" <c:out value="${param.findkey=='userid'?'selected':'' }" />>아이디</option>
				<option value="addrload" <c:out value="${param.findkey=='addrload'?'selected':'' }" />>도로명주소</option>
			</select>
			<input type="text" name="findvalue" value="${findvalue}">
			<button>조회</button>
		</form>
		
		<table border="1">
				<tr>
					<th>아이디</th>
					<th>도로명주소</th>
					<th>등록일자</th>
				</tr>
				<!-- var에는 풀어헤쳐질 값의 형 -->
			<c:forEach var="member" items="${mlist}">		
				<tr>
					<td> <a href="${path}/info.member?userid=${member.userid}">${member.userid}</a></td>
					<td> ${member.addrload}</td>
					<td> <fmt:formatDate value="${member.regidate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></td>
				</tr>
			</c:forEach>
				
		</table>
</body>
</html>