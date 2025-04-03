<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="acorn.Acorn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="/acornMVC/css/list.css"  type="text/css"  rel="stylesheet" >
</head>
<body>
<table>

<caption>에이콘 학생 목록</caption>



<tr>
<td>아이디 </td>
<td>비번 </td>
<td>이름 </td>
<td> 삭제 / 변경  </td>
</tr>
<%   ArrayList<Acorn> list  = (ArrayList<Acorn>) request.getAttribute("list");
 	for( Acorn   acorn : list){
%>

		<tr>
		<td><%=acorn.getId() %> </td>
		<td><%=acorn.getPw() %> </td>
		<td><%=acorn.getName() %> </td>
		<td> <a href="/acornMVC/delete?id=<%=acorn.getId() %>" >삭제</a>/
 <a href="/acornMVC/acorn?id=<%=acorn.getId() %>" > 변경</a> </td>
		</tr>

<%} %>
</table>

</body>
</html>