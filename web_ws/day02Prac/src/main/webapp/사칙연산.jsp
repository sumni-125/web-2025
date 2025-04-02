<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String su = request.getParameter("su1");
	String su_ = request.getParameter("su2");

	int su1 = Integer.parseInt(su);
	int su2 = Integer.parseInt(su_);

	int sum = su1 + su2;
	int sub = su1 - su2;
	int mul = su1 * su2;
	double div = (double) su1 / su2;
	%>

	<h1>1. 두 수를 입력받아서 사칙연산 제공하기</h1>

	<h2><%= su1%> + <%= su2%> = <%=sum %> </h2>

	<h2><%= su1%> - <%= su2%> = <%=sub %> </h2>

	<h2><%= su1%> × <%= su2%> = <%=mul %></h2>

	<h2><%= su1%> ÷ <%= su2%> = <%=div %> </h2>


</body>
</html>
