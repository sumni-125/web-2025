<%@page import="acorn.Acorn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/acornOne.css" rel='stylesheet'>
</head>
<body>
<%Acorn acorn =(Acorn) request.getAttribute("info"); %>
<h2>회원정보</h2>
	<form action="/day04Prac/deleteAcorn" method="post">
		<table>

			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="<%=acorn.getId()%>"></td>
			</tr>

			<tr>
				<td>pw</td>
				<td><input type="text" name="pw" value="<%=acorn.getPw() %>"></td>
			</tr>

			<tr>
				<td>name</td>
				<td><input type="text" name="name"
					value="<%=acorn.getName() %>"></td>
			</tr>

			<tr>
				<td colspan="2"><button>삭제하기</button></td>
			</tr>

		</table>
	</form>
</body>
</html>