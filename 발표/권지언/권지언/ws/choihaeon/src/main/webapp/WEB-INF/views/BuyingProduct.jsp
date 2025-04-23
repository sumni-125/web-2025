<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="Product.ProductDTO"%>
<%@ page import="BidsTransaction.BidDTO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
ProductDTO product = (ProductDTO) request.getAttribute("product");
String userId = (String) session.getAttribute("user_id");
Boolean isFavorited = (Boolean) request.getAttribute("isFavorited");
Integer currentBid = (Integer) request.getAttribute("current_bid");
ArrayList<BidDTO> bidHistory = (ArrayList<BidDTO>) request.getAttribute("bidHistory");
Boolean isProductOwner = (Boolean) request.getAttribute("isProductOwner");

// 경매 종료 시간 포맷
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String auctionEndTimeString = product.getAuction_end_time() != null ? sdf.format(product.getAuction_end_time()) : "";
long auctionEndTimeMs = product.getAuction_end_time() != null ? product.getAuction_end_time().getTime() : 0;
%>
<html>
<head>
<title>상품 상세 정보</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<style>
.container {
	display: flex;
	justify-content: center;
	margin-top: 40px;
}

.image-section {
	margin-right: 20px;
}

.product-image {
	width: 350px;
	height: 350px;
	object-fit: cover;
	border: 1px solid #ccc;
	margin-bottom: 20px;
}

.info-section {
	max-width: 600px;
}

.category-name {
	font-size: 14px;
	color: gray;
	margin-bottom: 5px;
}

.product-title {
	margin: 5px 0 10px;
}

.price-row {
	display: flex;
	justify-content: space-between;
	font-size: 18px;
	margin: 20px 0;
}

.price-left, .price-right {
	width: 45%;
	text-align: center;
	font-weight: bold;
}

.price-separator {
	width: 10%;
	text-align: center;
}

.current-bid-row {
	font-size: 16px;
	margin-bottom: 10px;
}

.meta-row {
	display: flex;
	justify-content: space-between;
	font-size: 15px;
	color: #555;
}

.description-box {
	margin: 30px 0 20px;
	padding: 20px;
	background-color: #f9f9f9;
	border: 2px solid #000;
}

.bid-section {
	display: flex;
	align-items: center;
	gap: 10px;
	margin-top: 20px;
}

.favorite-btn, .bid-btn, .bid-input {
	height: 42px;
	font-size: 16px;
}

.favorite-btn {
	background: none;
	border: 1px solid lightgray;
	cursor: pointer;
	width: 42px;
	padding: 0;
	font-size: 20px;
}

.bid-input {
	flex-grow: 1;
	padding: 0 10px;
	box-sizing: border-box;
}

.bid-btn {
	padding: 0 15px;
	border: none;
	background-color: black;
	color: white;
	cursor: pointer;
}

.action-buttons {
	display: flex;
	gap: 10px;
	margin-top: 20px;
}

.delete-btn {
	padding: 8px 15px;
	background-color: #ff4136;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.delete-btn:hover {
	background-color: #e60000;
}

.countdown-container {
	margin: 15px 0;
	padding: 10px;
	background-color: #f8f9fa;
	border-radius: 5px;
	border: 1px solid #dee2e6;
	text-align: center;
}

.countdown-timer {
	font-size: 18px;
	font-weight: bold;
	color: #dc3545;
}

.countdown-expired {
	color: #dc3545;
	font-weight: bold;
}

.auction-end-time {
	color: #6c757d;
	font-size: 14px;
	margin-top: 5px;
}

/* 입찰 내역 섹션 스타일 */
.bid-history-section {
	margin-top: 30px;
	border: 1px solid #dee2e6;
	border-radius: 5px;
	padding: 15px;
	background-color: #f8f9fa;
}

.bid-history-title {
	font-size: 18px;
	margin-bottom: 15px;
	color: #495057;
	border-bottom: 1px solid #dee2e6;
	padding-bottom: 10px;
}

.bid-history-table {
	width: 100%;
	border-collapse: collapse;
}

.bid-history-table th, .bid-history-table td {
	padding: 8px 12px;
	text-align: left;
	border-bottom: 1px solid #dee2e6;
}

.bid-history-table th {
	background-color: #e9ecef;
	color: #495057;
}

.bid-history-table tr:nth-child(even) {
	background-color: #f8f9fa;
}

.bid-history-table tr:hover {
	background-color: #e9ecef;
}

.bid-history-amount {
	font-weight: bold;
	color: #28a745;
}

.no-bids-message {
	text-align: center;
	padding: 20px;
	color: #6c757d;
	font-style: italic;
}

.winning-bid {
	background-color: #d4edda !important;
}

.winning-label {
	color: #28a745;
	font-weight: bold;
	font-size: 12px;
	margin-left: 5px;
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

	<input type="hidden" id="auctionEndTimeMs"
		value="<%=auctionEndTimeMs%>" />
	<input type="hidden" id="productId"
		value="<%=product.getProduct_id()%>" />

	<div class="container">
		<div class="image-section">
			<img
				src="<%=request.getContextPath()%>/<%=product.getImage_path() != null ? product.getImage_path() : "images/default.jpg"%>"
				alt="대표 이미지" class="product-image"
				onerror="this.src='<%=request.getContextPath()%>/images/default.jpg'">
		</div>

		<div class="info-section">
			<div class="category-name"><%=product.getCategory_name()%></div>
			<h2 class="product-title"><%=product.getTitle()%></h2>

			<div class="price-row">
				<div class="price-left">
					최소입찰가
					<%=product.getMinPrice()%>원
				</div>
				<div class="price-separator">|</div>
				<div class="price-right">
					희망입찰가
					<%=product.getMaxPrice()%>원
				</div>
			</div>

			<div class="current-bid-row">
				현재 입찰가:
				<%=(currentBid != null && currentBid > 0) ? currentBid + "원" : "입찰 없음"%>
			</div>

			<div id="countdown-container" class="countdown-container">
				<%
				if (!"판매완료".equals(product.getStatus()) && !"경매종료".equals(product.getStatus())) {
				%>
				<div>남은 경매 시간:</div>
				<div id="countdown" class="countdown-timer">로딩 중...</div>
				<div class="auction-end-time">
					경매 종료:
					<%=auctionEndTimeString%>
				</div>
				<%
				} else {
				%>
				<div class="countdown-expired">경매가 종료되었습니다!</div>
				<%
				}
				%>
			</div>

			<div class="meta-row">
				<div>
					조회수:
					<%=product.getView_count()%>회
				</div>
				<div>
					등록 날짜:
					<%=product.getRegister_date() != null ? sdf.format(product.getRegister_date()) : ""%>
				</div>
			</div>

			<div class="description-box">
				<%=product.getDescription()%>
			</div>

			<div class="bid-section">
				<%
				if (userId != null) {
				%>
				<%
				if ("판매완료".equals(product.getStatus()) || "경매종료".equals(product.getStatus())) {
				%>
				<p style="font-weight: bold; color: red;">경매가 종료된 물품입니다.</p>
				<%
				} else {
				%>
				<form action="favorite" method="post">
					<input type="hidden" name="product_id"
						value="<%=product.getProduct_id()%>" />
					<button type="submit" class="favorite-btn">
						<%=(isFavorited != null && isFavorited) ? "♡" : "찜"%>
					</button>
				</form>

				<form action="bid" method="post" class="bid-form">
					<input type="hidden" name="product_id"
						value="<%=product.getProduct_id()%>" /> <input type="number"
						name="bid_price" class="bid-input" placeholder="입찰 가격 입력" required />
					<button type="submit" class="bid-btn">입찰하기</button>
				</form>
				<%
				}
				%>
				<%
				} else {
				%>
				<p>로그인 후 입찰 및 찜이 가능합니다.</p>
				<%
				}
				%>
			</div>

			<%
			if (isProductOwner) {
			%>
			<div class="action-buttons">
				<button class="delete-btn" onclick="confirmDelete()">상품 삭제</button>
			</div>
			<script>
 		    function confirmDelete() {
        		if (confirm('정말로 이 상품을 삭제하시겠습니까? 이 작업은 되돌릴 수 없습니다.')) {
            		window.location.href = 'deleteproduct?product_id=<%=product.getProduct_id()%>
				';
					}
				}
			</script>
			<%
			}
			%>

			<!-- 입찰 내역 섹션 -->
			<div class="bid-history-section">
				<h3 class="bid-history-title">입찰 내역</h3>
				<%
				if (bidHistory != null && !bidHistory.isEmpty()) {
				%>
				<table class="bid-history-table">
					<thead>
						<tr>
							<th>입찰자</th>
							<th>입찰 금액</th>
							<th>입찰 시간</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						for (BidDTO bid : bidHistory) {
						%>
						<tr
							class="<%="Y".equals(bid.getIs_winning()) ? "winning-bid" : ""%>">
							<td><%=bid.getUser_id().equals(userId) ? "나" : bid.getUsername()%>
							</td>
							<td class="bid-history-amount"><%=bid.getBid_amount()%>원</td>
							<td><%=bid.getBid_time() != null ? sdf.format(bid.getBid_time()) : ""%>
							</td>
							<td>
								<%
								if ("Y".equals(bid.getIs_winning())) {
								%> <span class="winning-label">낙찰</span> <%
 }
 %>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<%
				} else {
				%>
				<p class="no-bids-message">아직 입찰 내역이 없습니다.</p>
				<%
				}
				%>
			</div>

		</div>
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

	<script>
		// 경매 종료 시간을 히든 필드에서 가져옴
		var countDownDate = parseInt(document
				.getElementById("auctionEndTimeMs").value);
		var productId = document.getElementById("productId").value;

		// 1초마다 카운트다운 업데이트
		var countdownTimer = setInterval(
				function() {
					// 현재 시간
					var now = new Date().getTime();

					// 남은 시간 계산
					var distance = countDownDate - now;

					// 시간 계산
					var days = Math.floor(distance / (1000 * 60 * 60 * 24));
					var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
							/ (1000 * 60 * 60));
					var minutes = Math.floor((distance % (1000 * 60 * 60))
							/ (1000 * 60));
					var seconds = Math.floor((distance % (1000 * 60)) / 1000);

					// 카운트다운 표시
					var countdownDisplay = "";
					if (days > 0)
						countdownDisplay += days + "일 ";
					if (hours > 0 || days > 0)
						countdownDisplay += hours + "시간 ";
					if (minutes > 0 || hours > 0 || days > 0)
						countdownDisplay += minutes + "분 ";
					countdownDisplay += seconds + "초";

					var countdownEl = document.getElementById("countdown");
					if (countdownEl) {
						countdownEl.innerHTML = countdownDisplay;
					}

					// 경매가 끝나면 카운트다운 중지 및 메시지 변경
					if (distance < 0) {
						clearInterval(countdownTimer);
						var containerEl = document
								.getElementById("countdown-container");
						if (containerEl) {
							containerEl.innerHTML = "<div class='countdown-expired'>경매가 종료되었습니다!</div>";
						}

						// 경매 종료 후 입찰 폼 비활성화
						var bidForm = document.querySelector(".bid-form");
						var bidInput = document.querySelector(".bid-input");
						var bidBtn = document.querySelector(".bid-btn");

						if (bidForm && bidInput && bidBtn) {
							bidInput.disabled = true;
							bidBtn.disabled = true;
							bidBtn.style.backgroundColor = "#6c757d";
						}

						// 서버에 경매 종료 상태 업데이트 요청
						fetch('auctionend?product_id=' + productId, {
							method : 'POST'
						});
					}
				}, 1000);
	</script>
</body>
</html>
