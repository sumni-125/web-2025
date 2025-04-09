<%@page import="day08Prac.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Member> list =(ArrayList<Member>) request.getAttribute("list"); %>
<table>
<tr>
<td>id</td>
<td>name</td>
</tr>

<%for(Member m: list){ %>
<tr>
<td><%=m.getM_id() %></td>
<td><%=m.getM_pw() %></td>
<td><%=m.getM_name() %></td>
<td><%=m.getM_tel() %></td>
<td><%=m.getM_birthday() %></td>
<td><%=m.getM_point() %></td>
<td><%=m.getM_grade() %></td>
</tr>
<%} %>

</table>
</body>
</html>