<%@page import="실습.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 목록</title>
<link href="css/reviewList.css" rel="stylesheet">
</head>
<body>
    <% ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("list"); %>

    <div class="header">
        <h1>리뷰</h1>
        <div class="btn-group">
            <button onclick="location.href='/project/bookList'">도서 목록</button>
            <button onclick="location.href='/project/reviewList'">리뷰</button>
            <button onclick="location.href='/library/libraryhome'">자리 예약</button>
        </div>
    </div>

    <div class="review-list">
	    <div class="nav-btn">
		    <div>
		    	<button class="writeBtn" onclick="location.href='/project/reviewAdd'">+리뷰 쓰기</button>
		    </div>
		    <div>
			    <button class="dateBtn" onclick="location.href='/project/reviewList'">날짜 순</button>
	    		<button class="starBtn" onclick="location.href='/project/reviewStar'">별점 순</button>
		    </div>
	    </div>
	    
        <% for (Review review : list) { %>
        <div class="review-item">
            <span class="review-title">📖 <%= review.getTitle() %></span>
            <span class="review-content">- "<%= review.getContent() %>"</span>
            <span class="review-rating">⭐ <%= review.getRating() %>점</span>
            <span class="review-user">👤 <%= review.getUser() %></span>
            <span class="review-date">🗓 <%= review.getDate() %></span>
            <button class="edit-btn" onclick="location.href='/project/reviewOne?id=<%= review.getId() %>'">수정</button>
            <button class="delete-btn" onclick="confirmDelete('<%= review.getId() %>')">삭제</button>
        </div>
        <% } %>
    </div>

    <script>
        function confirmDelete(id) {
            if (confirm("정말 삭제하시겠습니까?")) {
                location.href = '/project/reviewDelete?id=' + id;
            }
        }
    </script>

</body>
</html>
