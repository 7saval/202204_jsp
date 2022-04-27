<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//msg가 null이 아닐때 알림창 띄우기
	if('<%= request.getParameter("msg") %>' != 'null') {
		alert('<%= request.getParameter("msg") %>');
	}
	
	//가입 시 유효성 체크
	function joincheck() {
		var userid = document.getElementById('userid');
		var passwd = document.getElementById('passwd');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		console.log(userid);
		if(userid.value==''){
			alert('아이디를 입력해주세요!');
			userid.focus();
			return; //함수 종료
		}else if(passwd.value==''){
			alert('비밀번호를 입력해주세요!');
			passwd.focus();
			return;
		}else if(name.value==''){
			alert('이름을 입력해주세요!');
			name.focus();
			return;
		}else if(email.value==''){
			alert('이메일을 입력해주세요!');
			email.focus();
			return;
		}
		//submit
		document.getElementById('frmjoin').submit();
		
	}
</script>
</head>
<body>
	<h2>회원가입(insert)</h2>
	<form action="/jsp01/member/insert" method="post" id="frmjoin">
		아이디 <input type="text" name="userid" id="userid"> <br>
		비밀번호 <input type="password" name="passwd" id="passwd"> <br>
		이름 <input type="text" name="name" id="name"> <br>
		이메일 <input type="email" name="email" id="email"> <br>
		<button type="button" onclick="joincheck()">가입</button>
		<button type="button" onclick="location.href='/jsp01/member/selectList'">리스트</button>
	</form>
	<hr>
	<%
		if (request.getParameter("msg") != null){
	%>
			<%= request.getParameter("msg") %>
	<%	}
	%>
	
	
</body>
</html>