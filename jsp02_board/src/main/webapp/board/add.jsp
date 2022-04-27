<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('<%= request.getParameter("msg")%>' != 'null') {
		alert('<%= request.getParameter("msg")%>');
	}
	function addcheck(){
		var writer = document.getElementById('writer');
		var subject = document.getElementById('subject');
		var contents = document.getElementById('contents');
		if(writer.value=='') {
			alert('작성자를 입력하세요');
			writer.focus();
			return;
		}else if(subject.value=='') {
			alert('제목을 입력하세요');
			subject.focus();
			return;
		}else if(contents.value=='') {
			alert('내용을 입력하세요');
			contents.focus();
			return;
		}
		document.getElementById('frmadd').submit();
	}

</script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<h2>게시물 등록</h2>
	<form action="/jsp02_board/add.board" method="post" id="frmadd">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" id="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" id="subject"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="25" name="contents" id="contents"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" onclick="addcheck()">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	
	
	</form>
</body>
</html>