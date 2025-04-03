<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% String[] data  = (String[] ) request.getAttribute("like"); %>

<h2> 내가 좋아하는 것</h2>

<% for( String like : data)  { 
 out.println( like);
 } 
 %>


<h2> 내가 좋아하는 것</h2>
<ul>
<% for ( String like  : data) { %>
 <li> <%=like %></li>

<%} %>
</ul>





</body>
</html>