<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//메시지 창 띄우기
	if('<%= request.getParameter("msg") %>'!='null')
		alert('<%= request.getParameter("msg") %>');


	function addcheck() {		
		var custname = frmadd.custname;
		var phone = frmadd.phone;
		var address = frmadd.address;
		var joindate = frmadd.joindate;
		var grade = frmadd.grade;
		var city = frmadd.city;
		if(custname.value ==''){
			alert('회원성명이 입력되지 않았습니다');
			custname.focus();
			return;
		}else if(phone.value ==''){
			alert('전화번호가 입력되지 않았습니다');
			phone.focus();
			return;
		}else if(address.value ==''){
			alert('회원주소가 입력되지 않았습니다');
			address.focus();
			return;
		}else if(joindate.value ==''){
			alert('가입일자가 입력되지 않았습니다');
			joindate.focus();
			return;
		}else if(grade.value ==''){
			alert('고객등급이 입력되지 않았습니다');
			grade.focus();
			return;
		}else if(city.value ==''){
			alert('도시코드가 입력되지 않았습니다');
			city.focus();
			return;
		}
		frmadd.action = '/jsp03_hrd/member/join';
		frmadd.method = 'post';
		frmadd.submit();
	}
</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<h2>홈쇼핑 회원 등록</h2>
	<form action="" name="frmadd" id="frmadd">
		<table border="1">
			<tr>
				<th>회원번호(자동발생)</th>
				<td> <input type="number" name="custno" id="custno" readonly> </td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td> <input type="text" name="custname" id="custname"> </td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td> <input type="text" name="phone" id="phone"> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td> <input type="text" name="address" id="address"> </td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td> <input type="date" name="joindate" id="joindate"> </td>
			</tr>
			<tr>
				<th>고객등급</th>
				<td> 
					<select name="grade">
						<option value="A">A:VIP</option>
						<option value="B">B:일반</option>
						<option value="C">C:직원</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>거주도시</th>
				<td> <input type="text" name="city" id="city"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" onclick="addcheck()">등록</button>
					<button>조회</button>
				</td>
			</tr>
		</table>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>