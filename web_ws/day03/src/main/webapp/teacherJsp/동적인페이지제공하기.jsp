<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<%@ page import ="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  hello jsp !!!!! 
  
  
  <%    
    
     Date date  = new Date();  
     out.println( date);  
  
     
     
  %>
</body>
</html>