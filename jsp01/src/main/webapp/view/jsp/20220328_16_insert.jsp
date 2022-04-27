<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//db컨넥션
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("로딩 성공");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("접속 성공");
		
		String sql = "INSERT INTO member(userid, passwd, name, email)" +
				"VALUES(?,?,?,?)";
		
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//preparedstatement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt + "건 추가");
		//가입화면으로 이동
		//주소를 변경, msg전달
		String msg= URLEncoder.encode(cnt + "건 추가", "utf-8");
		response.sendRedirect("20220328_16_db.jsp?msg="+msg);	
	
	%>
</body>
</html>