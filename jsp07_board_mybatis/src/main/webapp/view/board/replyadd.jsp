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
	<h2>댓글</h2>
	<form action="${path}/reply/add" method="post">
		게시물번호<input type="text" name="bnum" value="${param.bnum}"> <br>
		<input type="hidden" name="restep" value="${param.restep}"> <br>
		<input type="hidden" name="relevel" value="${param.relevel}"> <br>
		내용 <textarea rows="5" cols="25" name="content"></textarea> <br>
		<button>추가</button>
	</form>
</body>
</html>