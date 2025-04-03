<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.content{

width: 200px;
height: 100px;
border:1px solid black;

}

</style>

</head>
<body>

<h2> Hello MVC</h2>

<%  String result  = (String) request.getAttribute("content");  %>

<div  class="content">

<% out.println( result ); %>
<%= result %>

</div>
</body>
</html>