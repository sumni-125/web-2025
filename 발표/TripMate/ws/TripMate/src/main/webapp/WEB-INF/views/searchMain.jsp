
<%@page import="tripMate.model.SearchDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Head 태그 안에 추가 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<link href="css/header.css" rel="stylesheet">
<link href="css/searchmain.css" rel="stylesheet">

<script>
	window.addEventListener("DOMContentLoaded", function() {
		const swiper = new Swiper(".mySwiper", {
			slidesPerView : 4, // 가로 4개
			slidesPerGroup : 1, // 1열씩 이동
			grid : {
				rows : 2,
				fill : "row"
			},
			spaceBetween : 30,
			loop : true, // 👉 마지막 → 처음으로 자동 순환
			pagination : {
				el : ".swiper-pagination",
				clickable : true
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev"
			}
		});
	});
</script>
</head>
<body>

	<header>
		<div class="logo">
			<a href="<%=request.getContextPath()%>/main"><img class="logoImg"
				src="image/logo.png" alt=""></a>
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
	List<SearchDTO> list = (List<SearchDTO>) request.getAttribute("list");
	%>
	<form action="/TripMate/list" method="get">
		<div class="input_st">
			<button type="submit">
				<!-- 검색로고 이미지 -->
				<img src="locimg/ico_search_b.svg" class="img_cs"
					style="width: 40px; height: 40px;">
			</button>
			<!-- 이미지 넣기 -->
			<input type="text" id="img_id" name="id">

		</div>
	</form>

	<hr>

	<%
	if (list != null && !list.isEmpty()) {
	%>
	<ul>
		<%
		for (SearchDTO sd : list) {
		%>
		<h2>
			<%=sd.getLocation()%>
		</h2>
		<%
		}
		%>
	</ul>
	<%
	}
	%>

	<!-- 전체 지역 보여줄 코드 -->
	<%
	List<SearchDTO> locationList = (List<SearchDTO>) request.getAttribute("locationList");
	%>

	<!-- 스와이프 라이브러리 사용 -->
	<div class="swiper mySwiper">
		<div class="swiper-wrapper">
			<%
			for (SearchDTO loc : locationList) {
			%>
			<div class="swiper-slide">
				<!-- getParmeter로 지정한 "id"를 가져와 해당 지역만 보여주기 -->
				<a href="/TripMate/list?id=<%=loc.getLocation()%>">
					<div class="img_st">
						<img
							src="<%=request.getContextPath()%>/locimg/<%=loc.getImg_url()%>"
							alt="<%=loc.getLocation()%>">
						<p class="loc_text"><%=loc.getLocation()%></p>
					</div>
				</a>
			</div>
			<%
			}
			%>
		</div>

		<!-- 네비게이션 (좌우 버튼) -->
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>

		<!-- 페이지네이션 (점) -->
		<div class="swiper-pagination"></div>
	</div>



</body>
</html>