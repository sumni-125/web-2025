<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
 <div class="main-content">
<h1>메인페이지</h1>

<% String id =(String) session.getAttribute("id"); %>

<%if(id != null){%>

	<nav>
	<a href="/day07Prj/logOut">로그아웃</a>
	</nav>
	<p><%=id %> 님 반갑습니다</p>
	
<%}else{ %>
<nav>
	<a href="/day07Prj/login">로그인</a>
	</nav>
<%} %>
</div>
</body>
</html>