<%@page import="시험연습하기.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, td{
border:1px solid black;
border-collapse: collapse;
}

</style>

</head>
<body>
<table>
<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	</tr>
<%ArrayList<Acorn> list =(ArrayList<Acorn>) request.getAttribute("acornList"); 

for(Acorn a:list){
	%>
	<tr>
	<td><%=a.getId() %></td>
	<td><%=a.getPw() %></td>
	<td><%=a.getName() %></td>
	</tr>
	
	<%
}
%>


</table>
</body>
</html>