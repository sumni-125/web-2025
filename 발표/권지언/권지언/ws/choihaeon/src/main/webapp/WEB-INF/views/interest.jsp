<%@page import="Product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 상품 목록</title>
<link rel="stylesheet" href="css/interesting.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<% ArrayList<ProductDTO> favorites = (ArrayList<ProductDTO>) request.getAttribute("favorites"); %>
	<% String userId = (String) session.getAttribute("user_id"); %>
	<header>
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
	</header>
	
	<h2>관심 상품</h2>

	<div class="product-list">
		<%
		if (favorites == null || favorites.isEmpty()) {
		%>
			<div class="empty-list">
				<div class="empty-message">관심 등록된 상품이 없습니다.</div>
				<div>상품을 찜해보세요!</div>
			</div>
		<%
		} else {
			for (ProductDTO p : favorites) {
		%>
			<div class="product-box" onclick="location.href='buyingproduct?product_id=<%=p.getProduct_id()%>'">
				<img src="<%=request.getContextPath()%>/<%=p.getImage_path() != null ? p.getImage_path() : "images/default.jpg"%>"
					 class="product-image" alt="상품 이미지" />
				<div class="product-info">
					<div class="product-title"><%=p.getTitle()%></div>
					<div class="seller-info">판매자: <%=p.getSeller_id()%></div>
					<div class="price-info"><%=p.getPrice()%>원</div>
				</div>
			</div>
		<%
			}
		}
		%>
	</div>

	<div class="footer">
		<div class="footer-content">
			<p>&copy; 2024 옥션 플랫폼. All rights reserved.</p>
			<div class="footer-links">
				<a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a>
				<% if (userId != null) { %>
				| <a href="receivedreviews">받은 리뷰 보기</a> | <a href="reviewform">리뷰
					작성하기</a>
				<% } %>
			</div>
		</div>
	</div>

</body>
</html>
