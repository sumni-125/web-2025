<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="css/signup.css" rel="stylesheet">
</head>
<body>
	<div class="container_wrap">
	    <div class="container">
	    	<div class="title">회원가입</div>
	        <form class="signupFrm" action="<%=request.getContextPath()%>/signup" method="post">
	            <input type="text" placeholder="아이디" name="id">
	            <input type="password" placeholder="비밀번호" name="pw">
	            <input type="password" placeholder="비밀번호확인" name="pwcheck">
	            <input type="text" placeholder="닉네임" name="nickname">
	            <button type="submit">가입하기</button>
	        </form>
	        <div class="login">
			<a href="<%=request.getContextPath()%>/login">로그인</a>
			</div>
	    </div>
	</div>
</body>
</html>