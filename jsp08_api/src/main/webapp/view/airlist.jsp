<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//조회
	/* function listCheck(e) {
		e.preventDefault();
		frmAir.action = '${path}/list.air';
		frmAir.submit();
	} */
	//파싱 후 db저장
	function parsingsave(e) {
		e.preventDefault();
		frmAir.action = '${path}/dbsave.air';
		frmAir.submit();
	}
</script>
</head>
<body>
	<h2>미세먼지 발령 경보 현황</h2>
	<form name="frmAir">
		측정연도 <input type="number" name="year" value="${param.year}">
		<!-- <button onclick="listCheck(event)">검색</button> -->
		<button onclick="parsingsave(event)">파싱 후 db저장</button>
	</form>
	<hr>
	<form action="${path}/list.air">
		지역명 <input type="text" name="districtName">
		<button>조회</button>
	</form>
	<hr>
	<%-- ${airlist} --%>
	<table border="1">
		<tr>
			<th>해제농도</th>
			<th>관리번호</th>
			<th>지역명</th>
			<th>발령농도</th>
			<th>발령시간</th>
			<th>해제일</th>
			<th>권역명</th>
			<th>해제시간</th>
			<th>경보단계</th>
			<th>항목명</th>
		</tr>
		<c:forEach var="air" items="${airlist}">
			<tr>
				<td>${air.clearVal}</td>
				<td>${air.sn}</td>
				<td>${air.districtName}</td>
				<td>${air.issueVal}</td>
				<td>${air.issueTime}</td>
				<td>${air.clearDate}</td>
				<td>${air.moveName}</td>
				<td>${air.clearTime}</td>
				<td>${air.issueGbn}</td>
				<td>${air.itemCode}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>