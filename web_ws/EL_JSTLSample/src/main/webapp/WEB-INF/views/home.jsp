<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Main</h2>
<%  String id  = (String) session.getAttribute("id"); %>



<% if( id == null) { %>
<a href="/EL_JSTLSample/login">로그인</a>
<%} %>

 <% if( id != null){ %>
<a href="/EL_JSTLSample/logout">로그아웃</a>
<%} %>
</body>
</html>