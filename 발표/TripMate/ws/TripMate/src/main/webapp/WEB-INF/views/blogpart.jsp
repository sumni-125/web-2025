<%@page import="tripMate.model.BlogMainDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>이미지 슬라이더</title>

<!-- Swiper CSS & JS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<link href="css/header.css" rel="stylesheet">
<style>


  .crrbtn {
    display: block;
    margin: 20px auto;
    border: none;
    color: white;
    background-color: #66d162;
    width: 100px;
    height: 35px;
    border-radius: 40px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

  .crrbtn:hover {
    background-color: #4caf50;
  }

  .swiper {
    width: 1300px;
    height: 310px;
    margin: 0 auto;
  }

  .swiper-slide {
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .swiper-slide img {
    border-radius: 20px;
    width: 230px;
    height: 300px;
    object-fit: cover;
    box-shadow: 0 4px 12px rgba(0,0,0,0.15);
  }

  .swiper-button-next,
  .swiper-button-prev {
    color: #999;
  }

  .swiper-pagination-bullet-active {
    background-color: rgb(203, 120, 120);
  }

  .title {
    margin-top: 40px;
    text-align: center;
  }

  .title h2 {
    font-size: 28px;
    color: #2c3e50;
    margin-bottom: 5px;
  }

  .title p {
    color: #888;
    font-size: 14px;
  }

  .content {
    margin-top: 40px;
    text-align: center;
  }

  .content input {
    font-size: 16px;
    width: 1300px;
    height: 100px;
    border-radius: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    background-color: #fff;
  }

  .home-link {
    display: block;
    text-align: center;
    margin-top: 20px;
    text-decoration: none;
    font-weight: bold;
    color: #3498db;
  }

  .home-link:hover {
    text-decoration: underline;
  }
</style>

<script>
  window.addEventListener("load", function () {
    new Swiper(".promotion .swiper", {
      slidesPerView: 5,
      spaceBetween: 10,
      centeredSlides: true,
      loop: true,
      autoplay: {
        delay: 3000
      },
      speed: 1000,
      navigation: {
        nextEl: ".promotion .swiper-button-next",
        prevEl: ".promotion .swiper-button-prev",
      }
    });
  });
</script>

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
    BlogMainDTO blog = (BlogMainDTO) request.getAttribute("blog");
    int imgIndex = (int) request.getAttribute("imgIndex");
%>

<form action="<%=request.getContextPath()%>/update" method="get">
  <input type="hidden" name="id" value="<%= blog.getId() %>">
  <button type="submit" class="crrbtn">수정</button>
</form>

<div class = "title">
<h2 style="text-align: center;"><%= blog.getTitle() %></h2>
<p style="text-align: center;"><%= blog.getRegDate() %></p>
</div>
<div class="promotion">
  <div class="swiper">
    <div class="swiper-wrapper">
      <c:forEach var="img" items="${blog.imageList}">
        <div class="swiper-slide">
          <img src="${pageContext.request.contextPath}/upload/${img}" alt="슬라이드 이미지">
        </div>
      </c:forEach>
    </div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
  </div>
</div>

<div class="content">
  <input type="text" style="width: 1300px; height: 100px;" 
         value="<%= blog.getContent() %>" readonly>
</div>

</body>
</html>
