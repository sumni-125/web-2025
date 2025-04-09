<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

<h2> EL 삼항연산자 사용</h2>

  ${empty sessionScope.id ? "<a href='/loginEL/login'>로그인</a>" : "<a href='/loginEL/logout'>로그아웃</a>" }
  
 
   
 
</body>
</html>