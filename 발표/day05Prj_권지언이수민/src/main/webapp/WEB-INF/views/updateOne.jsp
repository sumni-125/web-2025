<%@page import="teamproject.Parents"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Parents p =(Parents) request.getAttribute("p"); %>

<form action="/day05Prj/parentsUpdate" method="post" > 

<input type="text" name="parent_id" value="<%=p.getParent_id() %>" >
<input type="text" name="student_cd" value="<%=p.getStudent_cd() %>">
<input type="text" name="id" value="<%=p.getId() %>">
<input type="text" name="pw" value="<%=p.getPw() %>">
<input type="text" name="tel" value="<%=p.getTel() %>">
<button>수정하기</button>
</form>

</body>
</html>