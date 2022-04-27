<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/includeFile.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//로그인 체크
	function loginCheck() {
		const userid = frmLogin.userid;
		const passwd = frmLogin.passwd;
		
		if(userid.value==''){
			alert('아이디를 입력해 주세요');
			userid.focus();
		}else if(passwd.value==''){
			alert('비밀번호를 입력해주세요');
			passwd.focus();			
		}else{
			frmLogin.action = '${path}/login.member';
			frmLogin.method = 'post';
			frmLogin.submit();
		}
	}
</script>
</head>
<body>
	<h2>로그인</h2>
	<form name="frmLogin" action="">
		<table>
		<tr>
			<th>아이디</th>
			<!-- 쿠키의 값 세팅 -->
			<td> <input type="text" name="userid" value="${cookie.userid.value}"> </td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td> <input type="password" name="passwd"> </td>
		</tr>
		<tr>
			<th>아이디 기억하기</th>
			<!-- cookie.userid.value가 null이라면 -->
			
			<td> <input type="checkbox" name="idsave" <c:out value="${empty cookie.userid.value?'':'checked'}" />> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onclick="loginCheck()">로그인</button>
				<button type="reset">취소</button>
			</td>
		</tr>
			
	</table>
	</form>
	
</body>
</html>