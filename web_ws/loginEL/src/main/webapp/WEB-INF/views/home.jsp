<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

<h2> java 코드 </h2>


<% String id  = (String)session.getAttribute("id"); %>

<%if (id== null) {%>
  <a href="/loginEL/login">로그인</a>
<%}else{ %>
  <a href="/loginEL/logout">로그아웃</a>

<%} %>
</body>
</html>