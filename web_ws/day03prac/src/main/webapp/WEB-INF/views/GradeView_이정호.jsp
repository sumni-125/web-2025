<%@page import="java.util.ArrayList"%>
<%@page import="실습_이정호.Grade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin: 0 auto;
	}
	caption{
		font-size: 30px;
		font-weight: bold;
		margin-bottom: 20px;
	}
	th{
		border: 1px solid black;
		background-color: silver;
		padding: 10px 10px 10px 10px;
	}
	td{
		border: 1px solid black;
		width: 100px;
		height: 100px;
		text-align: center;
		font-weight: bold;
	}
	td:first-child{
		text-decoration: underline;
	}
	td:last-child {
		color: red;
		text-decoration: underline;
	}
</style>
</head>
<body>
	<%ArrayList<Grade> list = (ArrayList<Grade>) request.getAttribute("grade"); %>

	<table>
		<caption>-성적 리스트-</caption>
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>수학</th>
			<th>영어</th>
			<th>평균</th>
		</tr>
		<%for(Grade a : list){ %>
			<tr>
				<td><%=a.getName() %></td>
				<td><%=a.getKor() %>점</td>
				<td><%=a.getMath() %>점</td>
				<td><%=a.getEng() %>점</td>
				<td><%=a.getAvg() %>점</td>
			</tr>
		<%} %>
	</table>
</body>
</html>