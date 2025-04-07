<%@page import="teamproject.Parents"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parents List</title>
<style>
table, td{
border:1px solid black;
border-collapse:collapse;
}
</style>

</head>
<body>

<% ArrayList<Parents> list =(ArrayList<Parents>)  request.getAttribute("list"); %>
<table>

<tr>
<td>parent_id</td>
<td>student_cd</td>
<td>id</td>
<td>pw</td>
<td>tel</td>
</tr>
<%for(Parents p: list){ %>
<tr>
<td><%=p.getParent_id() %></td>
<td><%=p.getStudent_cd() %></td>
<td><%=p.getId()%></td>
<td><%=p.getPw() %></td>
<td><%=p.getTel() %></td>
<td><button onclick="location.href='/day05Prj/updateOne?parent_id=<%=p.getParent_id()%>'">수정하기</button>
</td>
<td><button onclick="location.href='/day05Prj/deleteOne?parent_id=<%=p.getParent_id()%>'">삭제하기</button>
</td>
</tr>

<%} %>
<tr>
<td colspan="5">
<button onclick="location.href='/day05Prj/insertOne'">학부모 삽입</button>
</td>
</tr>
</table>


</body>
</html>