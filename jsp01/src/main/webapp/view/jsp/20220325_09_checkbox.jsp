<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용가능한언어</h2>
	<form action="">
		<fieldset>
			<input type="checkbox" name="language" value="자바">자바
			<input type="checkbox" name="language" value="파이썬">파이썬
			<input type="checkbox" name="language" value="html5">html5
			<input type="checkbox" name="language" value="JAVASCRIPT">JAVASCRIPT
			<input type="checkbox" name="language" value="JSP">JSP
		</fieldset>
		<button>선택</button>
	</form>
	<hr>
	<%
		String[] langs = request.getParameterValues("language");
		if(langs != null){
	%>
		당신이 선택한 언어는
	<%		for(String lang:langs){

	%>
		 <%=lang %> <br>
	<%
			}
		}
	%>
	
</body>
</html>