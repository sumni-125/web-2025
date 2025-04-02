<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- jsp: html, css, javascript 자동으로 응답되는 코드로 변경 -->
	<!-- 1~10까지의 합 -->

	<%
	int sum = 0;
	for (int i = 0; i <= 10; i++) {
		sum += i;
	}
	%>

	<h1>sum = <%=sum %></h1>


</body>
</html>