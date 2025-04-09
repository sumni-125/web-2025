<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>상품상세페이지</h2> 


<% String goods  =(String) request.getAttribute("goods"); %>

<%= goods %>
<h3>F/w Collection </h3>
<%=goods%> 35,000원 <a href="/sessionCart/addCart?name=<%=goods%>">장반구니 추가</a>


</body>
</html>