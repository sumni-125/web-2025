<%@page import="movie.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.movie-item{
border:1px solid black;
border-radius: 5px;
width: 300px;
padding: 10px; 

}

.movie-item  img{
   max-width: 100px;
   border-radius: 4px;
  margin-right: 15px;
}

</style>
</head>
<body>

<% ArrayList<Movie> list  =(ArrayList<Movie>)  request.getAttribute("list"); %>


<% for( Movie movie : list){ %>
<div class="movie-item">
<!--  <img src="https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg">   -->
 <img  src="<%=movie.getImgUrl() %>"  alt=""> 
<div>영화제목 : <%=movie.getTitle() %></div>
<div>장르:<%=movie.getGenre() %></div>
</div>
<%} %>
</body>
</html>