<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2> 멋있는 뷰 , 이것이 뷰다 </h2>


<!--  모델 꺼내기, 데이터와 함께 응답하기 -->
<%   int hap  =( int) request.getAttribute("hap"); %>


<%=hap %>
</body>
</html>