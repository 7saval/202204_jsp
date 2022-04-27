<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modifyCheck(e) {
		e.preventDefault(); //기본이벤트 제거
		const content = document.getElementById('content');
		console.log(content.value.trim());
		if(content.value.trim()==''){
			alert('내용을 입력해주세요!');
			return;
		}
		document.getElementById('frmReplyModify').submit();
	}
</script>
</head>
<body>
	<h2>댓글의 수정</h2>
	<%-- ${reply} --%>
	<form id="frmReplyModify" action="${path}/reply/modify" method="post">
		게시물번호<input type="text" name="bnum" value="${reply.bnum}" readonly> <br>
		댓글번호<input type="text" name="rnum" value="${reply.rnum}" readonly> <br>
		내용 <textarea rows="5" cols="25" name="content" id="content">${reply.content}</textarea> <br>
		<button onclick="modifyCheck(event)">수정</button>
	</form>
</body>
</html>