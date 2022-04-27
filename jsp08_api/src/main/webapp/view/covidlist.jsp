<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('${param.msg}' != ''){
		alert('${param.msg}');
	}
	
	function valueCheck() {
		//유효성체크
		const startDt = frmList.startDt;
		const endDt = frmList.endDt;
		console.log(startDt);
		console.log(endDt);
		if(startDt.value == ''){
			alert('시작날짜를 입력하세요');
			startDt.focus();
			return false;
		}else if(endDt.value ==''){
			alert('종료날짜를 입력하세요');
			endDt.focus();
			return false;
		}
		return true; //유효성 체크 성공
	}
	//조회
	function listCheck(e) {
		e.preventDefault(); //기본이벤트 제거
		if(valueCheck()){
			frmList.action = '${path}/list.covid';
			frmList.submit();
		}
	}
	
	//파싱 후 db저장
	function parsingsave(e) {
		e.preventDefault(); //기본이벤트 제거
		if(valueCheck()){ //유효성체크 성공 시
			frmList.action = '${path}/dbsave.covid';
			frmList.submit();
		}
	}
	
</script>
</head>
<body>
	<%-- ${clist} --%>
	<h2>코로나 확진자 현황</h2>
	<form name="frmList" action="${path}/list.covid">
		기간 <input type="date" name="startDt" value="${param.startDt}"> ~
				<input type="date" name="endDt" value="${param.endDt}">
		<button onclick="listCheck(event)">조회</button>
		<button onclick="parsingsave(event)">파싱후db저장</button>
	</form>
	<table border="1">
		<tr>
			<th>게시물번호</th>
			<th>기준일</th>
			<th>기준시간</th>
			<th>누적확진자수</th>
			<th>일일확진자수</th>
			<th>사망자수</th>
			<th>등록일시분초</th>
			<th>수정일시분초</th>
		</tr>
		<c:forEach var="covid" items="${clist }">
			<tr>
				<td>${covid.seq}</td>
				<td>${covid.stateDt}</td>
				<td>${covid.stateTime}</td>
				<td>${covid.decideCnt}</td>
				<td>${covid.dailyDecideCnt}</td>
				<td>${covid.deathCnt}</td>
				<td>${covid.createDt}</td>
				<td>${covid.updateDt}</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>