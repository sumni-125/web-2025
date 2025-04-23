<%@page import="tripMate.model.BlogImgDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	img{
		width : 100px;
		height: 100px;
	}
</style>
</head>
<body>

<% ArrayList<BlogImgDTO> list = (ArrayList<BlogImgDTO>)request.getAttribute("img"); %>

<%for(BlogImgDTO blog : list) {%>
<img src="/blogTest/upload/<%= blog.getImageUrl() %>">
<%} %>
</body>
</html>