<%@page import="실습.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reviewForm.css">
</head>
<body>
	<%Review review = (Review) request.getAttribute("review"); %>
	
	<div class="container">
        <h2>리뷰 수정</h2>
        <form action="/project/reviewUpdate" method="post">
            <input type="hidden" name="id" value="<%=review.getId() %>">
            
            <div class="form-group">
                <label>회원</label>
                <input type="text" name="user" value="<%=review.getUser() %>" readonly="readonly">
            </div>
            
            <div class="form-group">
                <label>책 제목</label>
                <input type="text" name="title" value="<%=review.getTitle() %>" readonly="readonly">
            </div>
            
            <div class="form-group">
                <label>평점 (1~5)</label>
                <input type="number" name="rating" min="1" max="5" value="<%=review.getRating() %>" required>
            </div>
            
            <div class="form-group">
                <label>내용</label>
                <textarea name="content" required><%=review.getContent() %></textarea>
            </div>
            
            <button type="submit" onclick='alert("수정되었습니다.")'>수정하기</button>
        </form>
    </div>
</body>
</html>