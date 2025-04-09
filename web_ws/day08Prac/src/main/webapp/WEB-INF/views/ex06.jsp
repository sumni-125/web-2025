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

<h2>1~10출력하기</h2>

<%
	for(int i=1;i<=10;i++){
		out.print(i+" ");
	}
%>

<h2>JSTL 반복하기</h2>

<c:forEach var="i" begin="1" end="10">
${i} 
</c:forEach>

<h2>JSTL 2단출력하기</h2>
<c:forEach var="i" begin="1" end="9">
2 * ${i } = ${i*2 }<br>
</c:forEach>


</body>
</html>