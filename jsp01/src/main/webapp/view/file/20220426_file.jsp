<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<form action="/jsp01/upload.file" method="post" enctype="multipart/form-data">
		파일 <input type="file" name="file1">
		<button>전송</button>
	</form>
	<hr>
	<h2>파일 다운로드</h2>
	<a href="/jsp01/download.file?filename=${filename}">${filename}</a>
</body>
</html>