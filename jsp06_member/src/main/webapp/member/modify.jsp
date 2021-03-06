<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goPopup(){
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("${path}/member/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	//주소팝업 호출 수 실행할 함수
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.	
		document.frmModify.addrload.value = roadAddrPart1;
		document.frmModify.addrdetail.value = addrDetail;
		document.frmModify.zipcode.value = zipNo;		
}
	
	function modifyCheck(e) {
		//기본이벤트제거(submit기능 없애줌)
		e.preventDefault();
		let userid = frmModify.userid;
		let passwd = frmModify.passwd;
		
		
		if(userid.value == ''){
			alert('아이디를 입력해주세요');
			userid.focus();
			return;
		}else if(passwd.value == ''){
			alert('비밀번호를 입력해주세요');
			passwd.focus();
			return;
		}
		frmModify.submit();
	}
</script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<h2>회원수정</h2>
	<%-- ${member} --%>
	<form name="frmModify" action="${path}/modify.member" method="post" 
										enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td> <input type="text" name="userid" value="${member.userid}" readonly> </td>
			</tr>
			<tr>
				<th>기존 비밀번호</th>
				<td> <input type="password" name="passwd"> </td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td> <input type="text" name="zipcode" value="${member.zipcode}" size="5">
					<button type="button" onclick="goPopup()">검색</button>
				</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td> <input type="text" name="addrload" value="${member.addrload}" size="30"> </td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td> <input type="text" name="addrdetail" value="${member.addrdetail}"> </td>
			</tr>
			<tr>
				<th>사진</th>
				<td> 
					<img alt="사진없음" src="/savedir/${member.filename}" width="100">
					${member.filename} 
					<hr>
					<input type="file" name="photo"> 
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"> 
					<button onclick="modifyCheck(event)">수정</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>