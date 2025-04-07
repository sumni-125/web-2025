<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<link rel="stylesheet" href="css/reviewForm.css">
</head>
<body>
	<div class="container">
		<h2>리뷰 작성</h2>
		<form action="/project/reviewAdd" method="post">
			<div class="form-group">
				<label>회원</label>
				<input type="text" name="user" required>
			</div>
			<div class="form-group">
				<label>책 제목</label>
				<input type="text" name="title" required>
			</div>
			<div class="form-group">
				<label>평점 (1~5)</label>
				<input type="number" name="rating" min="1" max="5" required>
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" required></textarea>
			</div>
			<button type="submit">저장</button>
		</form>
	</div>
</body>
</html>
