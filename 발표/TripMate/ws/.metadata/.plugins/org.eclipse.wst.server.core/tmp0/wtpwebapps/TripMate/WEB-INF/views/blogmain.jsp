<%@page import="tripMate.model.BlogPost"%>
<%@page import="tripMate.model.BlogMainDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 리스트</title>
<style>

body {
	min-width: 1000px;
}

header {
	min-width: 1000px;
	border: 1px solid black;
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0 50px;
}

.logo {
	width: 110px;
	height: 110px;
}

.logoImg {
	padding: 10px;
	width: 90px;
	height: 90px;
}

header>div {
	font-size: 26px;
	font-weight: bold;
}

header>div>a {
	text-decoration: none;
	color: black;
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.upload {
	display: block;
	margin: 30px auto;
	border: none;
	border-radius: 20px;
	background-color: #66d162;
	width: 120px;
	height: 40px;
	font-weight: bold;
	color: white;
	font-size: 16px;
	cursor: pointer;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	transition: background-color 0.3s ease;
}

.upload:hover {
	background-color: #4caf50;
}

.wrap {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
	gap: 30px;
}

.img_box {
	width: 220px;
	background-color: white;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	text-align: center;
	padding-bottom: 15px;
}

.img_box:hover {
	transform: translateY(-5px);
	box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2);
}

.img {
	width: 100%;
	height: 250px;
	overflow: hidden;
	border-top-left-radius: 12px;
	border-top-right-radius: 12px;
}

.img img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.content {
	padding: 10px 15px;
	font-size: 14px;
}

.content strong {
	display: block;
	font-size: 16px;
	margin-bottom: 5px;
	color: #2c3e50;
}

a.non {
	text-decoration: none;
	color: inherit;
}
</style>
</head>
<body>


<header>
	<div class="logo">
		<a href="<%=request.getContextPath()%>/main"><img class="logoImg" src="image/logo.png"
			alt=""></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myTrip">여행일정</a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainsearch">관광지</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainblog">블로그</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myPage">마이페이지</a>

	</div>
</header>

<%
    List<BlogPost> blogList = (List<BlogPost>) request.getAttribute("blogList");
%>

<form action="<%= request.getContextPath() %>/blogreg" method="get" class="frm">
	<button type="submit" class="upload">업로드</button>
</form>

<div class="wrap">
<%
    ArrayList<BlogMainDTO> userBlogs = (ArrayList<BlogMainDTO>) request.getAttribute("userBlogs");
    if (userBlogs != null) {
        for (BlogMainDTO dto : userBlogs) {
%>
    <div class="img_box">
    <a href="<%= request.getContextPath() %>/blogpart?id=<%= dto.getId() %>&imgIndex=0">
        <div class="img">
           <% if (dto.getImageList() != null && !dto.getImageList().isEmpty()) { %>
    <img src="<%= request.getContextPath() + "/upload/" + dto.getImageList().get(0) %>" />
<% } else { %>
    <img src="<%= request.getContextPath() %>/images/default.jpg" width="200" height="250" />
<% } %>
        </div>
    </a>
    <div class="content">
            <strong><%= dto.getTitle() %></strong><br/>
            <%= dto.getContent() %>
        </div>
</div>
<%
        }
    }
%>
</div>

</body>
</html>