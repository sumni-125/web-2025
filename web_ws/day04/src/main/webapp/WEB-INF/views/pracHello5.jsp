<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.content{
   border:1px solid black;
   width: 200px;
   height: 100px;
   
}</style>
</head>
<body>

<h2> hello mvc </h2>

<%  String data  = (String) request.getAttribute("data"); %>
<div class="content">


<%= data %>
</div>
</body>
</html>