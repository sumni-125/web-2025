<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int su1 = (int) request.getAttribute("num1"); %>
<% int su2 = (int) request.getAttribute("num2"); %>
<% int add = (int) request.getAttribute("add"); %>
<% int minu = (int) request.getAttribute("minus"); %>
<% int mul = (int) request.getAttribute("multiple"); %>
<% int div = (int) request.getAttribute("divide"); %>
<h2>사칙연산</h2>
<%= su1 + " + " + su2 + " = " + add + "<br>"%>
<%= su1 + " - " + su2 + " = " + minu + "<br>" %>
<%= su1 + " x " + su2 + " = " + mul + "<br>" %>
<%= su1 + " ÷ " + su2 + " = " + div %>
</body>
</html>