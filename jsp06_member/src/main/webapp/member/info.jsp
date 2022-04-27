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
	<h2>개인정보</h2>
	<%-- ${member} --%>
	<!-- enctype:전송데이터의 타입(단순문자열) -->
	<!-- 파일전송시 : post, multipart/form-data -->
		<table border="1">
			<tr>
				<th>아이디</th>
				<td> ${member.userid} </td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td> ${member.zipcode}</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td> ${member.addrload} </td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td> ${member.addrdetail} </td>
			</tr>
			<tr>
				<th>사진</th>
				<td> 
					<img alt="사진없음" src="/savedir/${member.filename }" width="100">${member.filename }</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td> <fmt:formatDate value="${member.regidate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> 
					<button onclick="location.href='${path}/modiform.member?userid=${member.userid}'">수정</button>
					<button>회원탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>