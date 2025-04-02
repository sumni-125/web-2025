<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, tr, td {
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	width: 100px;
	height: 30px;
}

form {
	width: 300px;
	margin: 0 auto;
	padding: 50px;
}

input {
	padding: 0px;
	height: 30px;
}

button {
	padding: 0px;
	height: 30px;
}
</style>
"
</head>
<body>

	<table>
		<tr>
			<td>아이디</td>
			<td>비번</td>
			<td>이름</td>
			<td>포인트</td>
			<td>생년월일</td>
			<td>전화번호</td>
			<td>등급</td>
		</tr>

		<%
	ArrayList<SquidGameService> list = request.getAttribute("list");
	
	for(SquidGameService sg : list) {
		out.println("<tr>");

		out.println("<td>" + sg.getId() + "</td>");
		out.println("<td>" + sg.getPw() + "</td>");
		out.println("<td>" + sg.getName() + "</td>");
		out.println("<td>" + sg.getPoint() + "</td>");
		out.println("<td>" + sg.getBirth() + "</td>");
		out.println("<td>" + sg.getTel() + "</td>");
		out.println("<td>" + sg.getGrade() + "</td>");

		out.println("</tr>");
	}
	%>

	</table>

</body>
</html>