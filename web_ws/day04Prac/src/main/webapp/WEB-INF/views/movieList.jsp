<%@page import="day04Prac.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/movie.css" rel =" stylesheet">

</head>
<body>

<%ArrayList<Movie> list =(ArrayList<Movie>) request.getAttribute("list"); %>

<table>

<tr>
<td>아이디</td>
<td>제목</td>
<td>이미지</td>
<td>장르</td>
</tr>
<%for(Movie m : list) { %>

<tr>
<td><%=m.getId() %></td>
<td><%=m.getTitle() %></td>
<td><img src = <%=m.getImage_url() %>></td>
<td><%=m.getGenre() %></td>
</tr>
<%}%>

</table>


</body>
</html>