<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.util.ArrayList"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% ArrayList<String> list =(ArrayList<String>)  request.getAttribute("list"); %>


<h2> 상품목록</h2>


<%
for( String s :  list){
	out.println(s+  "<a href=\"/sessionCart/addCart?name="+ s+" \"> 담기</a> <br>");
}


%>


</body>
</html>