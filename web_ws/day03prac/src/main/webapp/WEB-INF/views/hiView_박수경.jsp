<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.box{

height:200px;
border:1px solid black;
margin:0 auto;

}

</style>
</head>
<body>
<%String hi =(String )request.getAttribute("hi"); 
String user = (String)request.getAttribute("user");
%>
<h1>안녕</h1>
<%=user %>
<div class="box">
<%=hi %>
</div>
</body>
</html>