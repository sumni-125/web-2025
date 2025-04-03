<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="acorn.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
 table{
 border:1px solid black;
 margin:0 auto;
 width: 400px;
 margin:0 auto;
 border-collapse: collapse;
 }
 
 td{
 border:1px solid black;
 text-align: center;
 }
 </style>
</head>
<body>
<%  

Acorn acorn  =(Acorn) request.getAttribute("acorn");

%>
<form name="frm" action="/acornMVC/update" method="post">
	<table>	
	<tr>
	<td>아이디</td>
	<td> <input type="text"  name="id"  value="<%=acorn.getId()%>"></td>
	</tr>
	
	<tr>
	<td>비번</td>
	<td><input type="text"  name="pw"  value="<%=acorn.getPw()%>"></td>
	</tr>
	
	
	<tr>
	<td>이름</td>
	<td><input type="text"  name="name"  value="<%=acorn.getName()%>"></td>
	</tr>
	
	
	<tr>
	<td colspan="2"> 
	 <button>변경</button>
	</td>
	 
	</tr>
	
	</table>

</form>
</body>
</html>