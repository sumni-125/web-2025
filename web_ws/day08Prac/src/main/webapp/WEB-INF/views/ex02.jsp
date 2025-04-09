<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<String> list = (ArrayList<String>) request.getAttribute("list"); %>
<%
for(String item:list){
	
	out.println(item);
}
%>
<h2> EL JSTL </h2>

<!-- itmems의 내용은 저장소의 list라는 이름으로 저장된 거 꺼내요기 -->
<!-- var의 내용은 오른쪽 배열에 있는 요소 하나씩을 저장하는 변수의 이름, 변수는 내부적으로 pageContext라는 저장소에 저장 -->

<c:forEach var="item" items="${list}">
${item}
</c:forEach>

</body>
</html>