<%@page import="s02_member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>회원리스트</h2>
	<button onclick="location.href = '/jsp01/member/selectList'">조회</button> 
	<button onclick="location.href ='/jsp01/view/db/20220329_01_insert.jsp'">가입</button> <br>
	<%-- <%= request.getAttribute("mlist")%> --%>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<%
			//다운캐스팅
			List<Member> mlist = (List<Member>)request.getAttribute("mlist");
			if(mlist != null){
				//ArrayList는 length대신 size()
				for(int i=0;i<mlist.size();i++){
		%>
					<tr>
						<td><a href="/jsp01/member/modify?userid=<%=mlist.get(i).getUserid()%>">
							<%=mlist.get(i).getUserid() %></a></td>
						<td><%=mlist.get(i).getPasswd() %></td>
						<td><%=mlist.get(i).getName() %></td>
						<td><%=mlist.get(i).getEmail() %></td>
					</tr>
		<%		}
			}
		%>
	
	</table>
	
	
</body>
</html>