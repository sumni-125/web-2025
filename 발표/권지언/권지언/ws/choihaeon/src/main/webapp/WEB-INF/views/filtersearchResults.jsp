<%@page import="java.util.ArrayList"%>
<%@page import="Product.filterproductDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리별 상품 검색 결과</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<style>
body {
	font-family: sans-serif;
	text-align: center;
	margin: 0;
	padding: 0;
}

h2 {
	margin: 30px 0;
}

.product-container {
	display: grid;
	grid-template-columns: repeat(5, 1fr);
	gap: 30px;
	justify-content: center;
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

.product-card {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 15px;
	background-color: #f9f9f9;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.product-card img {
	width: 100%;
	height: 150px;
	object-fit: cover;
	border-radius: 5px;
}

.product-card h3 {
	margin: 10px 0 5px;
	font-size: 16px;
}

.product-card p {
	font-size: 14px;
	color: #555;
}

.current_price {
	color: red;
}

.header {
	background-color: #ffffff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	padding: 15px 20px;
	margin-bottom: 20px;
}

.header-content {
	display: flex;
	align-items: center;
	justify-content: space-between;
	max-width: 1200px;
	margin: 0 auto;
}

.header-left {
	display: flex;
	align-items: center;
}

.header-right {
	display: flex;
	align-items: center;
	gap: 15px;
}

.welcome-msg {
	margin-right: 10px;
	font-weight: bold;
}

.header-btn {
	text-decoration: none;
	color: #333;
	padding: 5px 10px;
	border-radius: 4px;
	border: 1px solid #ddd;
	transition: all 0.3s;
}

.header-btn:hover {
	background-color: #f5f5f5;
}

.notification-icon-container {
	position: relative;
	margin-left: 10px;
}

.notification-icon {
	color: #333;
	font-size: 18px;
	text-decoration: none;
}

.notification-badge {
	position: absolute;
	top: -8px;
	right: -8px;
	background-color: #ff4136;
	color: white;
	border-radius: 50%;
	width: 18px;
	height: 18px;
	font-size: 12px;
	display: flex;
	align-items: center;
	justify-content: center;
}

.footer {
	background-color: #f8f9fa;
	padding: 20px 0;
	margin-top: 50px;
	border-top: 1px solid #e7e7e7;
}

.footer-content {
	max-width: 1200px;
	margin: 0 auto;
	text-align: center;
	color: #6c757d;
}

.footer-links {
	margin-top: 10px;
}

.footer-links a {
	color: #6c757d;
	text-decoration: none;
	margin: 0 5px;
}

.footer-links a:hover {
	text-decoration: underline;
}

.content {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 20px;
}

.actions {
	margin-bottom: 20px;
	text-align: right;
}

.action-btn {
	display: inline-block;
	padding: 8px 16px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 4px;
	transition: background-color 0.3s;
}

.action-btn:hover {
	background-color: #0056b3;
}

/* 검색 기능 스타일 */
.search-container {
	flex: 1;
	max-width: 500px;
	margin: 0 20px;
	position: relative;
}

.search-form {
	display: flex;
	width: 100%;
}

.search-input {
	flex: 1;
	border: 2px solid #e0e0e0;
	border-radius: 20px 0 0 20px;
	padding: 8px 15px;
	font-size: 14px;
	transition: border-color 0.3s;
}

.search-input:focus {
	outline: none;
	border-color: #007bff;
}

.search-btn {
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 0 20px 20px 0;
	padding: 8px 15px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.search-btn:hover {
	background-color: #0056b3;
}

.search-filters {
	display: none;
	position: absolute;
	top: 100%;
	left: 0;
	width: 100%;
	background-color: white;
	border: 1px solid #e0e0e0;
	border-radius: 4px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 10px;
	z-index: 9999;
	margin-top: 5px;
}

.filter-group {
	margin-bottom: 10px;
}

.filter-title {
	font-weight: bold;
	margin-bottom: 5px;
	font-size: 14px;
}

.filter-options {
	display: flex;
	flex-wrap: wrap;
	gap: 8px;
}

.filter-option {
	background-color: #f5f5f5;
	border: 1px solid #ddd;
	border-radius: 20px;
	padding: 4px 10px;
	font-size: 12px;
	cursor: pointer;
	transition: all 0.2s;
}

.filter-option:hover, .filter-option.active {
	background-color: #e3f2fd;
	border-color: #007bff;
	color: #007bff;
}

.filter-button {
	background-color: transparent;
	border: none;
	color: #6c757d;
	font-size: 14px;
	cursor: pointer;
	display: flex;
	align-items: center;
	position: absolute;
	right: 60px;
	top: 50%;
	transform: translateY(-50%);
}

.filter-button i {
	margin-right: 4px;
}

.product-status {
	background-color: #f8d7da;
	color: #721c24;
	display: inline-block;
	padding: 2px 8px;
	border-radius: 4px;
	margin-top: 5px;
	font-size: 12px;
}

/* 로딩 및 에러 메시지 스타일 유지 */
.loading-indicator {
	width: 100%;
	text-align: center;
	padding: 20px;
	color: #888;
}

.error-message {
	text-align: center;
	padding: 20px;
	color: #d9534f;
}

@media ( max-width : 768px) { /* 랭킹 관련 스타일 제거됨 */
}

.filter-button {
	background-color: transparent;
	border: none;
	color: #6c757d;
	font-size: 14px;
	cursor: pointer;
	display: flex;
	align-items: center;
	position: absolute;
	right: 60px;
	top: 50%;
	transform: translateY(-50%);
}

.filter-button i {
	margin-right: 4px;
}

.notification-icon-container {
	display: inline-block;
	position: relative;
	margin-left: 20px;
}

.notification-icon {
	color: #333;
	font-size: 18px;
	text-decoration: none;
}

.notification-badge {
	position: absolute;
	top: -8px;
	right: -8px;
	background-color: #ff4136;
	color: white;
	border-radius: 50%;
	width: 18px;
	height: 18px;
	font-size: 12px;
	display: flex;
	align-items: center;
	justify-content: center;
}

.search-btn {
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 0 20px 20px 0;
	padding: 8px 15px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.search-btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%
	String userId = (String) session.getAttribute("user_id");
	String statusMessage = (String) request.getAttribute("statusMessage");
	%>

	<!-- 헤더 포함 -->
	<div class="header">
		<div class="header-content">
			<div class="header-left">
				<h1>
					<a href="index" style="text-decoration: none; color: inherit;">옥션
						플랫폼</a>
				</h1>
			</div>

			<!-- 검색 기능 추가 -->
			<div class="search-container">
				<form action="search" method="get" class="search-form">
					<input type="text" name="keyword" class="search-input"
						placeholder="찾고 싶은 상품을 검색해보세요">
					<button type="button" class="filter-button" id="show-filters">
						<i class="fas fa-sliders-h"></i> 필터
					</button>
					<button type="submit" class="search-btn">
						<i class="fas fa-search"></i>
					</button>
				</form>

				<!-- 검색 필터 드롭다운 -->
				<div class="search-filters" id="search-filters"
					style="display: none;">
					<div class="filter-group">
						<div class="filter-title">카테고리</div>
						<div class="filter-options">
							<span class="filter-option" data-category="all">전체</span> <span
								class="filter-option" data-category="electronics">전자기기</span> <span
								class="filter-option" data-category="fashion">패션</span> <span
								class="filter-option" data-category="beauty">뷰티/미용</span> <span
								class="filter-option" data-category="sports">스포츠/레저</span> <span
								class="filter-option" data-category="books">도서</span> <span
								class="filter-option" data-category="appliances">가전제품</span>
						</div>
					</div>

					<div class="filter-group">
						<div class="filter-title">가격 범위</div>
						<div class="filter-options">
							<span class="filter-option" data-price="0-50000">5만원 이하</span> <span
								class="filter-option" data-price="50000-100000">5만원~10만원</span>
							<span class="filter-option" data-price="100000-300000">10만원~30만원</span>
							<span class="filter-option" data-price="300000-">30만원 이상</span>
						</div>
					</div>

					<div class="filter-group">
						<div class="filter-title">상품 상태</div>
						<div class="filter-options">
							<span class="filter-option" data-status="onsale">판매중</span> <span
								class="filter-option" data-status="closed">경매종료</span>
						</div>
					</div>

					<div class="filter-group">
						<div class="filter-title">정렬 방식</div>
						<div class="filter-options">
							<span class="filter-option" data-sort="relevance">관련성순</span> <span
								class="filter-option" data-sort="priceAsc">가격 낮은순</span> <span
								class="filter-option" data-sort="priceDesc">가격 높은순</span> <span
								class="filter-option" data-sort="newest">최신순</span> <span
								class="filter-option" data-sort="endingSoon">마감임박순</span>
						</div>
					</div>
				</div>
			</div>

			<div class="header-right">
				<%
				if (userId != null) {
				%>
				<span class="welcome-msg"><%=userId%>님 환영합니다</span> <a href="mypage"
					class="header-btn">마이페이지</a>
				<form action="logout" method="post" style="display: inline;">
					<button type="submit" class="header-btn"
						style="cursor: pointer; background: none; border: 1px solid #ddd; padding: 5px 10px; border-radius: 4px;">로그아웃</button>
				</form>

				<!-- 알림 아이콘 추가 -->
				<div class="notification-icon-container">
					<a href="notifications" class="notification-icon"> <i
						class="fa fa-bell"></i> <%
 // 미읽은 알림 개수 가져오기
 int unreadNotificationCount = 0;
 try {
 	Notification.NotificationDAO notificationDAO = new Notification.NotificationDAO();
 	unreadNotificationCount = notificationDAO.getUnreadNotificationCount(userId);
 } catch (Exception e) {
 	e.printStackTrace();
 }
 if (unreadNotificationCount > 0) {
 %> <span class="notification-badge"><%=unreadNotificationCount%></span>
						<%
						}
						%>
					</a>
				</div>
				<%
				} else {
				%>
				<a href="login" class="header-btn">로그인</a> <a href="signup"
					class="header-btn">회원가입</a>
				<%
				}
				%>
			</div>
		</div>
	</div>

	<h2>선택한 카테고리의 상품 목록</h2>

	<div class="product-container">
		<%
		ArrayList<filterproductDTO> searchResults = (ArrayList<filterproductDTO>) request.getAttribute("searchResults");
		if (searchResults != null && !searchResults.isEmpty()) {
			for (filterproductDTO p : searchResults) {
		%>
			<a href="<%=request.getContextPath()%>/buyingproduct?product_id=<%=p.getProduct_id()%>"
				class="product-card-link">
				<div class="product-card">
					<img src="<%=p.getImage_path()%>" alt="<%=p.getTitle()%> 이미지">
					<h3><%=p.getTitle()%></h3>
					<p class="current_price">
						현재 입찰가:
						<%=p.getCurrentprice()%>원
					</p>
				</div>
			</a>
		<%
		}
		} else {
		%>
		<p>해당 카테고리에 등록된 상품이 없습니다.</p>
		<%
		}
		%>




	</div>
	<!-- 푸터 추가 -->
	<div class="footer">
		<div class="footer-content">
			<p>&copy; 2024 옥션 플랫폼. All rights reserved.</p>
			<div class="footer-links">
				<a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a>
				<%
				if (userId != null) {
				%>
				| <a href="receivedreviews">받은 리뷰 보기</a> | <a href="reviewform">리뷰
					작성하기</a>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>
