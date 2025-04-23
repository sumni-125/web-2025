<%@page import="tripMate.model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="css/header.css" rel="stylesheet">
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
	position: relative;
}

h1 {
	text-align: center;
	margin-top: 40px;
	color: #333;
}

.top-bar {
	position: relative;
	width: 100%;
	height: 60px;
}

.add-btn-container {
	position: absolute;
	top: 20px;
	right: 40px;
}

.add-btn {
	display: inline-block;
	padding: 10px 20px;
	background-color: #28a745;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	font-weight: bold;
	transition: background-color 0.2s ease;
}

.add-btn:hover {
	background-color: #218838;
}

.wrap {
	width: 600px;
	margin: 30px auto;
	display: flex;
	flex-direction: column;
	gap: 20px;
}

.trip-card {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	transition: transform 0.2s ease;
}

.trip-card:hover {
	transform: scale(1.02);
	cursor: pointer;
}

.trip-title {
	font-size: 20px;
	font-weight: bold;
	color: #007bff;
	margin-bottom: 10px;
}

.trip-place {
	font-size: 16px;
	color: #333;
	margin-bottom: 5px;
}

.trip-dates {
	font-size: 14px;
	color: #666;
}

.budget-btn {
	display: inline-block;
	padding: 8px 14px;
	background-color: #ffc107;
	color: #333;
	text-decoration: none;
	border-radius: 4px;
	font-size: 13px;
	font-weight: bold;
	transition: background-color 0.2s ease;
}

.budget-btn:hover {
	background-color: #e0a800;
}
</style>
<%
ArrayList<Schedule> scheduleList = (ArrayList<Schedule>) request.getAttribute("schedule");
%>
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

	<div class="top-bar">
		<h1>나의 여행</h1>
		<div class="add-btn-container">
			<a href="<%=request.getContextPath()%>/tripPlace" class="add-btn">일정
				추가하기</a>
		</div>
	</div>

	<div class="wrap">
		<%
		if (scheduleList != null && !scheduleList.isEmpty()) {
			for (Schedule s : scheduleList) {
		%>
		<div class="trip-card" onclick="location.href='<%=request.getContextPath()%>/tripSet?sd_code=<%=s.getSd_code()%>'">
			<div class="trip-title"><%=s.getName()%></div>
			<div class="trip-place">
				여행지:
				<%=s.getPlace_name()%></div>
			<div class="trip-dates">
				여행 기간:
				<%=s.getStart_date()%>
				~
				<%=s.getEnd_date()%></div>
			<div style="text-align: right; margin-top: 15px;">
				<a href="cost?sd_code=<%=s.getSd_code()%>" class="budget-btn">가계부
					추가하기</a>
			</div>
		</div>
		<%
		}
		} else {
		%>
		<div class="trip-card" style="text-align: center; color: #999;">등록된
			여행이 없습니다.</div>
		<%
		}
		%>
	</div>

</body>
</html>