<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${id ==null }">
로그인 안되어있음 <a href="/loginEL/login">로그인</a>
</c:if>

<c:if test="${sessionScope.id != null }">
로그인 되어있음 <br>반갑습니다 ${id }님 <a href="/loginEL/logout">로그아웃</a>
</c:if>

</body>
</html>