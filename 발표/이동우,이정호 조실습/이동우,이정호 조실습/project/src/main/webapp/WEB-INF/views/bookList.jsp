<%@page import="실습.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<link href="css/bookList.css" rel="stylesheet">
</head>
<body>

    <% ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list"); %>

    <div class="header">
        <h1>도서 목록</h1>
        <div class="btn-group">
            <button onclick="location.href='/project/bookList'">도서 목록</button>
            <button onclick="location.href='/project/reviewList'">리뷰</button>
            <button onclick="location.href='/library/libraryhome'">자리 예약</button>
        </div>
    </div>

	<div class="bookstore">
	    <div class="categoryList">
		    <div>
			    <button onclick="location.href='/project/bookList'">전체</button>
		        <button onclick="location.href='/project/bookOne?category=소설'">소설</button>
		        <button onclick="location.href='/project/bookOne?category=에세이'">에세이</button>
		        <button onclick="location.href='/project/bookOne?category=전문서'">전문서</button>
		        <button onclick="location.href='/project/bookOne?category=만화'">만화</button>
		    </div>
		    <div>
			    <input type="text" placeholder="찾는 도서를 입력하세요" class="select">
				<button onclick="searchBook()">검색</button>
		    </div>
	    </div>
	
	    <div class="book-list">
	        <% for (Book book : list) { %>
	        <div class="book-item">
	        	<span class="book-id">🆔 <%= book.getId() %></span>
	            <span class="book-title">📖 <%= book.getTitle() %></span>
	            <span class="book-author">✍ <%= book.getAuthor() %></span>
	            <span class="book-category">📂 <%= book.getCategory() %></span>
	        </div>
	        <% } %>
	    </div>
    </div>

	<script>
	    function searchBook() {
	        const input = document.querySelector('.select');
	        const keyword = input.value.trim();
	
	        if (keyword === "") {
	            alert("검색어를 입력해주세요.");
	            return;
	        }
	
	        // 검색어를 URL에 추가해서 이동
	        location.href = '/project/selectOne?title=' + encodeURIComponent(keyword);
	    }
	</script>
</body>
</html>
