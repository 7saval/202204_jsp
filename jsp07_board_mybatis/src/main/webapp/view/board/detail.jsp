<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.reply{
		display: flex;
	}
</style>
 <!-- fontawesome 아이콘 -->
    <script src="https://kit.fontawesome.com/5bbe282217.js" crossorigin="anonymous"></script>

<script type="text/javascript">
	function removeCheck() {
		const result = confirm('정말 삭제하시겠습니까?');
		if(result){
			location.href='${path}/board/remove?bnum=${board.bnum}';
		}
	}
	//댓글삭제
	function removeReply(rnum){
		//alert(rnum);
		const result = confirm('댓글을 삭제하시겠습니까?');
		if(result){
			location.href='${path}/reply/remove?bnum=${board.bnum}&rnum='+rnum;
		}
	}
</script>
</head>
<body>
	<h2>상세조회</h2>
	<table border="1">
			<tr>
				<th>번호</th>
				<td>${board.bnum}</td>
			</tr>
			<tr>
				<th>작성자아이디</th>
				<td>${board.userid}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <pre>${board.content}</pre></td>
			</tr>
			<tr>
				<th>파일</th>
					<td>
						<c:forEach var="boardfile" items="${bflist}">
							<a href="${path}/file/download?filename=${boardfile.filename}">${boardfile.filename}</a><br>
						</c:forEach>
					</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.readcnt}</td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td> <fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="location.href='${path}/board/modiform?bnum=${board.bnum}'">수정폼</button>
					<button onclick="removeCheck()">삭제</button>
					<button 
						onclick="location.href='${path}/view/board/replyadd.jsp?bnum=${board.bnum}&restep=0&relevel=0'">
							댓글</button>
					<button onclick="location.href='${path}/board/list'">리스트</button>
				</td>
			</tr>
	</table>
	<%-- ${rlist} --%>
	<fieldset>
		<legend><h4>댓글</h4></legend>
		<c:forEach var="reply" items="${rlist}">
			<div class="reply">
				<c:forEach var="i" begin="1" end="${reply.relevel}">
					<div>
						<i class="fab fa-replyd"></i>
					</div>
				</c:forEach>
				<div>
					<%-- 댓글번호 : ${reply.rnum} <br>
					restep : ${reply.restep} relevel : ${reply.relevel} <br> --%>
					<pre>${reply.content}</pre>
					<fmt:formatDate value="${reply.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
					<button 
						onclick="location.href='${path}/view/board/replyadd.jsp?bnum=${board.bnum}&restep=${reply.restep}&relevel=${reply.relevel}'">
						댓글</button>
					<button onclick="location.href='${path}/reply/modiform?rnum=${reply.rnum}'">수정</button>
					<button onclick="removeReply(${reply.rnum})">삭제</button>
				</div>
			</div>
		<hr>
		</c:forEach>
	</fieldset>
	
</body>
</html>