<%@page import="dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('<%=request.getParameter("msg") %>' != 'null')
		alert('<%=request.getParameter("msg") %>');
	
</script>
</head>
<body>
	<%
		//findkey null일 때 처리
		String findkey = request.getParameter("findkey");
		String findvalue = request.getParameter("findvalue");
		if (findkey == null) findkey = "";
		if (findvalue == null) findvalue = "";
	%>
	<%@include file="../header.jsp" %>
	<h3>게시물 리스트</h3>
	<form action="/jsp02_board/list.board">
		<select name="findkey">
			<option value="writer" <%out.print(findkey.equals("writer")?"selected":"");%>>작성자</option>
			<option value="subject" <%out.print(findkey.equals("subject")?"selected":"");%>>제 목</option>
			<option value="contents" <%out.print(findkey.equals("contents")?"selected":"");%>>내 용</option>
		</select>
		<input type="text" name="findvalue" value="<%=findvalue%>">
		<button>조회</button>
		<button type="button" onclick="location.href='/jsp02_board/board/list.jsp'">초기화</button>
	</form>
	<hr>
	<!-- 조회리스트 -->
	<form action="/jsp02_board/remove.board">
		<table border="1">
			<tr>
				<th>seq</th>
				<th>writer</th>
				<th>subject</th>
				<th>contents</th>
				<th>regidate</th>
				<th>modidate</th>
				<th> <button>delete</button></th>
			</tr>	
		<% 
		List<Board> blist = (List<Board>)request.getAttribute("blist");
		if(blist != null) {
			for(Board board:blist){
		%>
			<tr>
				<td><%=board.getSeq()%></td>
				<td><%=board.getWriter()%></td>
				<td> <a href="/jsp02_board/modiform.board?seq=<%=board.getSeq()%>"><%=board.getSubject()%></a></td>
				<td><pre><%=board.getContents()%></pre></td>
				<td><%=board.getRegidate()%></td>
				<td><%=board.getModidate()%></td>
				<td align="center"> <input type="checkbox" name="removes" value="<%=board.getSeq()%>"></td>
			</tr>	
				
		<%	}
		}
		%>
		</table>
	</form>
	
</body>
</html>