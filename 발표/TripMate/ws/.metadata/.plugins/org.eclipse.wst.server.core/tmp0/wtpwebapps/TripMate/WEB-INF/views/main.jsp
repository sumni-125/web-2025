<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/header.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<%
String[] places = {"영종도", "우도", "여수", "춘천", "전주", "부산", "강릉"};
String name = "밤바다";
String myplace = "여수";
String start_day = "25.04.16";
String end_day = "25.04.18";
String thema = "테마이름";
%>
<script>
	function search() {
		alert("검색 클릭");
	}
</script>
</head>
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
<body>
	<div class="container">
		<div class="schedule">
			<h2>내 여행 일정</h2>
			<div class="myschedule">
				<p onclick="alert('클릭함')"><%=name%>
					|
					<%=myplace%>
					|
					<%=start_day%>
					~
					<%=end_day%>
					|
					<%=thema%>
				</p>
			</div>
		</div>
		<div class="search">
			<input type="text" /> <img onclick="search()"
				src="image/search-icon.png" alt="돋보기아이콘">
		</div>
		<h2 class="recommendtext">관광지 검색 추천</h2>
		<div class="recommend">
			<ul>
				<%
				for (String place : places) {
				%>

				<a href="<%=request.getContextPath()%>/search?place=<%=place%>">
					<li><img src="image/<%=place%>.png"></li>
					<h3><%=place%></h3>
				</a>

				<%
				}
				%>
			</ul>
		</div>
	</div>
</body>
</html>