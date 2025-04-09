<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>메인페이지</h2>

<!-- 로그인 여부에 따라 다르게 보이게하기 -->
<!-- 세션 저장소에 로그인 정보를 확인하고 로그인 상태인지 알 수 있다 -->

<% String loginId =(String) session.getAttribute("loginId"); %>

<%if(loginId != null){%>
	<h2><%=loginId %> 님 반갑습니다</h2>
	<a href="/day07Prac/logOut">로그아웃</a>
	<a href="/day07Prac/order">주문정보</a>
<%}else{ %>
	<a href="/day07Prac/login">로그인</a>
	<a href="/day07Prac/order">주문정보</a>
<%} %>

</body>
</html>