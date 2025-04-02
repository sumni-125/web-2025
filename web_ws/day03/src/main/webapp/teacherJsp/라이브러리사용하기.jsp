<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ page import="com.acorn.teacher.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 

<% 
    MyUtil u =  new MyUtil();
	String result =u.getDivisor(12);
	out.println( result);
	 
%>


</body>
</html>