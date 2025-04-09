<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="sample.Music" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% ArrayList<Music> musics  = (ArrayList<Music>)   request.getAttribute("music");  %>

<%
   for( Music music : musics ){
	   out.println( music.getTitle());
	   out.println( music.getSinger());
	}

%>

<h4> JSTL , EL 사용</h4>
<c:forEach  var="m" items="${music}">
	${m.title}
	${m.singer} 
</c:forEach>



</body>
</html>