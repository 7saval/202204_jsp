<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//메세지 알림창
	if('<%=request.getParameter("msg")%>' != 'null')
			alert('<%=request.getParameter("msg")%>');


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
			frmLogin.action = '/jsp04_session/login.log';
			frmLogin.method = 'post';
			frmLogin.submit();
		}
	}
</script>
</head>
<body>
	<%
		//쿠키 읽기
		String userid = null; //쿠키(userid)에 저장된 값을 저장할 변수
		Cookie[] cookies = request.getCookies(); //쿠키의 배열
		if(cookies != null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("userid")){ //쿠키의 이름이 userid인 값 찾기
					userid = cookie.getValue();
				}
			}
		}
		
	%>
	<h2>로그인</h2>
	<form name="frmLogin" action="">
		<table>
		<tr>
			<th>아이디</th>
			<!-- 쿠키의 값 세팅 -->
			<td> <input type="text" name="userid" value="<%=userid%>"> </td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td> <input type="password" name="passwd"> </td>
		</tr>
		<tr>
			<th>아이디 기억하기</th>
			
			<td> <input type="checkbox" name="idsave" checked> </td>
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