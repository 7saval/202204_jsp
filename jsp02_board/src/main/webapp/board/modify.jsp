<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<h2>수정</h2>
	<% 
		Board board= (Board)request.getAttribute("board");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		Date regidate = board.getRegidate();
		String fmRegidate = sf.format(regidate);
		Date modidate = board.getModidate();
		String fmModidate = sf.format(modidate);
	%>
	<form id="frmmodify" action="/jsp02_board/modify.board" method="post">
		<table>
			<tr>
				<th>순번</th>
				<td><input type="text" name="seq" value="<%=board.getSeq() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%=board.getWriter() %>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="<%=board.getSubject() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="25" name="contents" id="contents"><%=board.getContents() %></textarea></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><%=fmRegidate%></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><%=fmModidate%></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	
	
	</form>
</body>
</html>