<%@page import="acorn.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/acorn.css" rel =" stylesheet">

</head>
<body>
<%
ArrayList<Acorn> list =(ArrayList<Acorn>) request.getAttribute("list");
%>

<table>

<tr>
<td>id</td>
<td>pw</td>
<td>name</td>
</tr>
<!-- request 먼저 꺼내기-->
<%
for(Acorn a:list){
	

%>

<tr>
<td><%=a.getId() %></td>
<td><%=a.getPw() %></td>
<td><%=a.getName() %></td>
<td><a href="/day04Prac/acornOne?id=<%=a.getId() %>">수정하기</a></td>
<td><a href="/day04Prac/deleteAcorn?id=<%=a.getId() %>">삭제하기</a></td>
</tr>
<%
}
%>

</table>
<a href="/day04Prac/regAcorn">가입하기</a>
</body>
</html>