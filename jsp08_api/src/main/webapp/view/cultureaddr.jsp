<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- ncpClientId: 네이버의 map api신청 승인키 -->
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ukqfsgw1gc"></script>
		<script>
		//gmap이 null이라면 alert('맵이 없습니다.')
		
		function mapMake() {
			//gmap이 ''일 경우			
			if('${gmap}'=='') {
				document.getElementById('map').innerHTML = '지도 정보가 없습니다';
				var x = 0;
				var y = 0;
				return;
			}else{
				var x = '${gmap.x}';
				var y = '${gmap.y}';
				
			}
			console.log(x);
			console.log(y);
			//map id에 맵 생성
			var map = new naver.maps.Map('map', {
				center: new naver.maps.LatLng(y, x),//경도,위도
				zoom: 15
			});
			//마커생성
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(y, x),
			    map: map
			});
			
		}	
	</script>
</head>
<body onload="mapMake()">
	<%-- ${gmap} --%>
	<h2>서울시 문화위치정보 명칭 검색</h2>
	<form action="${path}/addr.culture">
		명칭 <input type="text" name="name" value="${param.name}">
		<button>검색</button>
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>문화공간코드</th>
			<td>${map.FAC_CODE}</td>
		</tr>
		<tr>
			<th>장르분류코드</th>
			<td>${map.SUBJCODE}</td>
		</tr>
		<tr>
			<th>장르분류명</th>
			<td>${map.FAC_NAME}</td>
		</tr>
		<tr>
			<th>문화공간명</th>
			<td>${map.CODENAME}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${map.ADDR}</td>
		</tr>
	</table>
	<!-- 지도표시위치 -->
	<div id="map" style="width:90%;height:400px; margin:auto"></div>
</body>
</html>