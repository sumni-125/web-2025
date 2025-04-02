<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
img{
width: 300px;
height: 300px;
}
</style>

</head>
<body>
<% ArrayList<String> list = (ArrayList<String>) request.getAttribute("imglogs"); 

for(int i=0;i<list.size();i++){%>
	
	<img src='<%=list.get(i) %>'>
<%
}
%>



</body>
</html>