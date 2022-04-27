<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#active{
		color: red;
		font-size: 20px;
		 
	}
</style>
</head>
<body>
	<h2>게시물 리스트</h2>
	<form action="${path}/board/list" >
		<select name="findkey">
			<option value="userid" <c:out value="${param.findkey=='userid'?'selected':''}" />>작성자</option>
			<option value="subject" <c:out value="${param.findkey=='subject'?'selected':''}" />>제목</option>
			<option value="content" <c:out value="${param.findkey=='content'?'selected':''}" />>내용</option>
		</select>
		<input type="text" name="findvalue" value="${param.findvalue}">
		<button>조회</button>
		<button type="button" onclick="location.href='${path}/view/board/add.jsp'">게시물 작성</button>
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자아이디</th>
			<th>제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="board" items="${blist}">
			<tr>
				<td>${board.bnum}</td>
				<td>${board.userid}</td>
				<td> <a href="${path}/board/detail?bnum=${board.bnum}">${board.subject}</a></td>
				<td> <fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${board.readcnt}</td>
			</tr>
		</c:forEach>	
	</table>
	<hr>
	<!-- 페이징 -->
	<%-- ${findmap} --%>
	<hr>
	<c:if test="${findmap.startPage != 1}">
		<a href="${path}/board/list?curPage=${findmap.startPage-1}&findkey=${param.findkey}&findvalue=${param.findvalue}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${findmap.startPage}" end="${findmap.endPage}">
		<!-- 현재페이지 -->
		<c:if test="${i==findmap.curPage}">
			<a id="active" href="${path}/board/list?curPage=${i}&findkey=${param.findkey}&findvalue=${param.findvalue}">${i}</a> 
		</c:if>
		<!-- 현재페이지 아닐때 -->
		<c:if test="${i !=findmap.curPage}">
			<a href="${path}/board/list?curPage=${i}&findkey=${param.findkey}&findvalue=${param.findvalue}">${i}</a> 
		</c:if>
		
	</c:forEach>
	<c:if test="${findmap.endPage<findmap.totPage}">
		<a href="${path}/board/list?curPage=${findmap.endPage+1}&findkey=${param.findkey}&findvalue=${param.findvalue}">다음</a>
	</c:if>
	
</body>
</html>