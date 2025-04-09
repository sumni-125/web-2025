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

	<h2> JSTL c:if 사용</h2>
    <c:if test="${empty sessionScope.id}">
        <!-- 로그인하지 않은 경우 -->
        <p>로그인되지 않았습니다. <a href="/loginEL/login">로그인</a></p>
    </c:if>
    
    
    <c:if test="${not empty sessionScope.id}">
        <!-- 로그인한 경우 -->
        <p>로그인되었습니다. 환영합니다, ${sessionScope.id}님. <a href="/loginEL/logout">로그아웃</a></p>
    </c:if>
 
     
    
</body>
</html>