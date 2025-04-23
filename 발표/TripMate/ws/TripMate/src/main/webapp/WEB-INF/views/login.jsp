<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap');
* {
	font-family: "Noto Sans KR", serif;
	font-optical-sizing: auto;
	font-weight: 400;
	font-style: normal;
}

body {
	margin: 0;
	padding: 0;
}

.container {
	display: flex;
	height: 100vh;
}

.leftBox {
	width: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
}

.logo{
	width: 550px;
}

.rightBox {
	width: 50%;
	background-color: #D9D9D9;
}

.hello{
	text-align: center;
	font-size: 45px;
	font-weight: bold;
	margin-top: 24%;
}

.loginForm {
	display: flex;
	flex-direction: column;
	width: 55%;
	gap: 25px;
	margin: 55px auto;
}

.loginForm>input{
	height: 55px;
	font-size: 25px;
	font-weight: bold;
	line-height: 30px;
	padding: 2px 20px;
	outline: none;
	border-style: none;
	border-radius: 5px;
	
	box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

.loginForm>input[type="password"]{
	margin-bottom: 25px;
}

button{
	height: 45px;
	font-size: 25px;
	font-weight: 600;
	line-height: 30px;
	border: none;
	border-radius: 5px;
	background-color: #0095F6;
	color: white;
	
	box-shadow: 0 2px 8px rgba(0,0,0,0.3);
}

button:hover{
		cursor: pointer;
	}


</style>
</head>
<body>
	<div class="container">
		<div class="leftBox">
		<img class="logo" src="image/logo.png">
		</div>
		<div class="rightBox">
			<div class="hello">어서오세요</div>
			<form class="loginForm" action="/TripMate/login" method="post">
				<input type="text" placeholder="아이디" name="id">
				<input type="password" placeholder="비밀번호" name="pw">
				<button class="loginBtn" type="submit">로그인</button>
				<button class="signupBtn" type="button" onclick="location.href='/TripMate/signup'">회원가입</button>
			</form>
			
		</div>
	</div>
</body>
</html>