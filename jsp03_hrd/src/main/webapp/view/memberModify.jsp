<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//메시지 창 띄우기
	if('<%=request.getParameter("msg")%>'!='null')
		alert('<%=request.getParameter("msg")%>');
	
	function modifycheck() {		
		var custname = frmmodify.custname;
		var phone = frmmodify.phone;
		var address = frmmodify.address;
		var joindate = frmmodify.joindate;
		var grade = frmmodify.grade;
		var city = frmmodify.city;
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
		
		frmmodify.action = '/jsp03_hrd/member/modify';
		frmmodify.method = 'post';
		frmmodify.submit();
	}
</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<!-- 회원수정 -->
	<h2>회원수정</h2>
	<%
		Member member = (Member)request.getAttribute("member");
		String grade = member.getGrade();
		//삼항연산자 사용
		//out.println(grade.equals("A")?"selected":"");
	%>
	<form action="" name="frmmodify">
		<table border="1">
			<tr>
				<th>회원번호(자동발생)</th>
				<td> <input type="number" name="custno" value="<%=member.getCustno() %>" readonly> </td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td> <input type="text" name="custname" value="<%=member.getCustname() %>" id="custname"> </td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td> <input type="text" name="phone" value="<%=member.getPhone() %>" id="phone"> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td> <input type="text" name="address" value="<%=member.getAddress() %>" id="address"> </td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td> <input type="date" name="joindate" value="<%=member.getJoindate() %>" id="joindate"> </td>
			</tr>
			<tr>
				<th>고객등급</th>
				<td> 
					<select name="grade" >
						<option value="A" <%out.println(grade.equals("A")?"selected":"");%>>A:VIP</option>
						<option value="B" <%out.println(grade.equals("B")?"selected":"");%>>B:일반</option>
						<option value="C" <%out.println(grade.equals("C")?"selected":"");%>>C:직원</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>거주도시</th>
				<td> <input type="text" name="city" value="<%=member.getCity() %>" id="city"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" onclick="modifycheck()">수정</button>
					<button>조회</button>
				</td>
			</tr>
		</table>
	</form>
	
		<%@include file="footer.jsp" %>
</body>
</html>