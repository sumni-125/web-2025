<%@page import="User.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 관리</title>
<link rel="stylesheet" href="css/profileManager.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<%
UserDTO user = (UserDTO) request.getAttribute("user");
if (user == null) {
   response.sendRedirect("login");
   return;
}
%>
<%
String userId = (String) session.getAttribute("user_id");
String statusMessage = (String) request.getAttribute("statusMessage");
%>
</head>
<body>
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
<div class="layout-wrapper">
	<!--사이드 메뉴바-->
    <div class="sidebar">
        <h2>프로필 관리</h2>
        <div class="section">
            <h3>거래 정보</h3>
            <ul>
                <li><a href="registerproduct">상품 등록</a></li>
                <li><a href="reviewform">리뷰 작성</a></li>
                <li><a href="viewInterest">관심 상품</a></li>
            </ul>
        </div>

        <div class="section">
            <h3>내 정보</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/mypage">프로필 정보</a></li>
                <li><a href="${pageContext.request.contextPath}/profileManager">프로필 관리</a></li>
                <li><a href="receivedreviews">리뷰 보기</a></li>
            </ul>
        </div>
    </div>

	<!-- 메인 내용 -->
    <div class="mypage-container">

        <!-- 프로필 이미지 수정 -->
        <div class="profile-box">
            <form id="profileForm" enctype="multipart/form-data">
                <div class="user_profile">
                    <input id="imageUpload" name="profileImage" type="file" accept="image/jpeg,image/png" hidden>
                    <img id="profileImagePreview" src="<%=user.getProfile_image()%>" alt="프로필 이미지">
                    <div class="profile-detail">
                        <div class="id"><%=user.getUser_id()%></div>
                        <div class="image-btn">
                            <button type="button" id="uploadTrigger">이미지 변경</button>
                            <button type="button" id="deleteProfileImage">삭제</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <!-- 프로필 정보 수정 -->
        <form action="${pageContext.request.contextPath}/profileManager" method="post">
            <div class="profile">
                <h4>프로필 정보</h4>
                <div class="unit column">
                    <div class="info-label">이름</div>
                    <div class="input-row">
                        <div class="info-value">
                            <input type="text" name="user_name" value="<%=user.getUsername()%>">
                        </div>
                        <button class="edit-button">변경</button>
                    </div>
                </div>
            </div>

            <div class="myInfo">
                <h4>내 계정</h4>
                <div class="unit column">
                    <div class="info-label">이메일</div>
                    <div class="input-row">
                        <div class="info-value">
                            <input type="text" name="email" value="<%=user.getEmail()%>">
                        </div>
                        <button class="edit-button">변경</button>
                    </div>
                </div>

                <div class="unit column">
                    <div class="info-label">비밀번호</div>
                    <div class="input-row">
                        <div class="info-value">
                            <input type="text" name="password" value="<%=user.getPassword()%>">
                        </div>
                        <button class="edit-button">변경</button>
                    </div>
                </div>
            </div>

            <div class="privateInfo">
                <h4>개인 정보</h4>
                <div class="unit column">
                    <div class="info-label">전화번호</div>
                    <div class="input-row">
                        <div class="info-value">
                            <input type="text" name="phone" value="<%=user.getPhone()%>">
                        </div>
                        <button class="edit-button">변경</button>
                    </div>
                </div>

                <div class="unit column">
                    <div class="info-label">주소</div>
                    <div class="input-row">
                        <div class="info-value">
                            <input type="text" name="address" value="<%=user.getAddress()%>">
                        </div>
                        <button class="edit-button">변경</button>
                    </div>
                </div>
            </div>
        </form>
        
    </div>
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
<script>
const imageInput = document.getElementById("imageUpload");
const uploadButton = document.getElementById("uploadTrigger");
const deleteButton = document.getElementById("deleteProfileImage");

uploadButton.addEventListener("click", () => {
    imageInput.click();
});

imageInput.addEventListener("change", () => {
    const file = imageInput.files[0];
    if (!file) return;

    const formData = new FormData();
    formData.append("profileImage", file);

    fetch("profileUpdate", {
        method: "POST",
        body: formData
    }).then(res => res.text())
    .then(path => {
        document.getElementById("profileImagePreview").src = path;
    }).catch(err => {
        console.error(err);
        alert("업로드 실패");
    });
});

deleteButton.addEventListener("click", () => {
    fetch("profileDelete", {
        method: "POST"
    }).then(res => res.text())
    .then(path => {
        document.getElementById("profileImagePreview").src = path;
    }).catch(err => {
        console.error(err);
        alert("삭제 실패");
    });
});
</script>

</body>
</html>
