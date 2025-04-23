
<%@page import="tripMate.model.LocationHotelDTO"%>
<%@page import="tripMate.model.LocationInfoDTO"%>
<%@page import="tripMate.model.SearchDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/header.css" rel="stylesheet">

<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    padding: 30px;
    margin: 0;
}


h2 {
    text-align: center;
    margin: 50px 0 20px;
    font-size: 1.8rem;
    color: #2c3e50;
}

.wrap {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 30px;
    justify-content: center;
}

.img_info {
    background-color: white;
    border-radius: 15px;
    overflow: hidden;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.img_info:hover {
    transform: translateY(-7px);
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
}

.img {
    height: 200px;
    overflow: hidden;
    background-color: #dfe6e9;
    display: flex;
    justify-content: center;
    align-items: center;
}

.img img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;
}

.content {
    padding: 20px;
}

.content h3 {
    margin: 0 0 10px;
    font-size: 1.2rem;
    color: #34495e;
}

.content p {
    margin: 5px 0;
    font-size: 0.95rem;
    color: #636e72;
}

.title_con {
    font-weight: 500;
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

<% List<SearchDTO> list = (List<SearchDTO>)request.getAttribute("list"); %>

<% if (list != null && !list.isEmpty()) { %>
<ul>
<% for(SearchDTO sd : list) { %>
    <h2><%= sd.getLocation() %></h2>
    
    
<% List<LocationInfoDTO> lite =(List<LocationInfoDTO> ) request.getAttribute("lite"); %>

<h2>추천 관광지</h2>
<div class = "wrap">
<%for(LocationInfoDTO lit : lite){ %>
<div class = "img_info">
	<div class = "img">
	<img src = "locc/<%= lit.getImg_url() %>" alt = "관광지 이미지" style = "width : 300px; height: 250px;"></div>
	<div class = "content">
	<h3><%= lit.getTitle() %></h3>
	<br>
	<p class = "title_con"><%= lit.getContent() %></p>
	<br>
	<p><%= lit.getAddress() %></p>
	</div>
</div>
<%} %>
</div>

<% List<LocationHotelDTO> hotel =(List<LocationHotelDTO> ) request.getAttribute("hotel"); %>

<h2>추천 숙소</h2>
<div class = "wrap">
<%for(LocationHotelDTO lit : hotel){ %>
<div class = "img_info">
	<div class = "img">
	<img src = "hotel/<%= lit.getImg_url() %>" style = "width : 300px; height: 250px;"></div>
	<div class = "content">
	<h3><%= lit.getTitle() %></h3>
	<br>
	
	<!-- 별점 -->
	<%
    int rating = lit.getRate(); // 예: DB에서 받아온 별점 (1~5)
    for(int i = 1; i <= 5; i++) {
        if(i <= rating) {
%>
            <span style="color: gold; font-size: 20px;">★</span>
<%
        } else {
%>
            <span style="color: lightgray; font-size: 20px;">☆</span>
<%
        }
    }
%>

	<p class = "title_con">가격 : <%= lit.getPrice() %></p>
	<p>주소 : <%= lit.getAddress() %></p>
	</div>
</div>
<%} %>
</div>

<% } %>
</ul>
<% } else { %>
    <script>
        alert("검색 결과가 없습니다.");
        location.href="/blogTest/mainsearch";
    </script>
<% } %>








</body>
</html>