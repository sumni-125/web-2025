<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.box{

width:200;
height:200;
border:1px solid black;
text-align:center;
margin:0 auto:
line-height:200px;

}

</style>

</head>
<body>


<%
ArrayList<Integer> list =(ArrayList<Integer>) request.getAttribute("divisor");
%>




<h2>약수정보</h2>

<div class = "box">
<%=list %>
</div>

</body>
</html>