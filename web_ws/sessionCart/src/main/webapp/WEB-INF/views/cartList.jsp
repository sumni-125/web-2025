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


<% 
 
//세션에서 장바구니가져오기
ArrayList<String> list =(ArrayList<String>)  session.getAttribute("cartList"); %>


<h2> 장바구니 목록</h2>

 

<% if( list.size()==0) {  
%>
    <h3> 장바구니 목록이 없습니다</h3>	

<%} %>	




<%
 for( String s :  list){
 	out.println( "<a href=\"/sessionCart/deleteCart?name="+s+"\">"  +s   +" 삭제</a>  <br>");
 }
%>


</body>
</html>