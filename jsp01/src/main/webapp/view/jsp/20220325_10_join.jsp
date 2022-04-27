<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 주말 과제 -->
	<!-- 아이디, 비밀번호, 이메일, 이름, 성별(radio), 가입경로(select):인터넷,지인소개,광고, 
	가능시간대(checkbox):새벽,오전,오후,마감 
	
	버튼 눌렀을 때 결과창에 가입정보 출력
	-->
	

	<h2>회원가입</h2>
	
	<form action="20220325_10_result.jsp" method="post">
	<fieldset>
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"> <br>
		이메일 : <input type="email" name="email"> <br>
		이름 : <input type="text" name="name"> <br>
		성별 : <input type="radio" name="gender" value="남자">남자
		<input type="radio" name="gender" value="여자">여자 <br>
		가입경로 : <select name="way">
						<option>인터넷</option>
						<option>지인소개</option>
						<option>인스타광고</option>
					</select> <br>
		가능시간대 : <input type="checkbox" name="time" value="새벽">새벽
		<input type="checkbox" name="time" value="오전">오전 
		<input type="checkbox" name="time" value="오후">오후 
		<input type="checkbox" name="time" value="마감">마감 <br>
	</fieldset>
	<button>저장</button>
	</form>
</body>
</html>