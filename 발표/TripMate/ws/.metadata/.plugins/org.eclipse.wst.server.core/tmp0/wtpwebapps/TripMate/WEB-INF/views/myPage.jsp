<%@page import="tripMate.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>마이페이지</title>
<link href="css/header.css" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap');
* {
	font-family: "Noto Sans KR", serif;
	font-optical-sizing: auto;
	font-weight: 400;
	font-style: normal;
}
body, html {
	margin: 0;
	padding: 0;
	overflow: hidden; 
}
body{
	background-color: #f5f5f5;
}

.container_wrap {
	justify-content: center;
	max-width: 50%;
	height: 100vh;
	margin: 0 auto;
	background-color: white;
}

.container {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 25px;
		box-shadow: 0 2px 8px rgba(0,0,0,0.3);
}

.title{
	text-align: center;
	font-size: 40px;
	font-weight: bold;
}

.updateForm{
	width: 55%;
	display: flex;
	flex-direction: column;
	margin: 50px auto;
	gap: 20px;
}

.updateForm input{
	background-color: #f5f5f5;
	height: 55px;
	font-size: 25px;
	font-weight: 700;
	line-height: 30px;
	padding: 2px 20px;
	outline: none;
	border-style: none;
	border-radius: 5px;
	box-shadow: 0 2px 8px rgba(0,0,0,0.3);
}

.btn {
	height: 50px;
	font-size: 25px;
	font-weight: 500;
	line-height: 30px;
	border: none;
	padding: 10px 0;
	border-radius: 5px;
	background-color: #0095F6;
	color: white;
	box-shadow: 0 2px 8px rgba(0,0,0,0.4);
}

.btn:hover {
	filter: brightness(110%);
	transition: filter 0.2s;
	cursor: pointer;
}
.updateForm input::placeholder {
	color: #999;
	font-weight: 600;
}

.updateForm>input[name="nick"]{
	margin-bottom: 30px;
}

.logout {
	margin-bottom: 70px;
	font-size: 24px;
}
.logout a {
	color: black;
	text-decoration: none;
}

.logout a:hover{
	text-decoration: underline;
	color: #0095F6;
}



</style>
</head>
<body>
<header>
	<div class="logo">
		<a href="<%=request.getContextPath()%>/main"><img class="logoImg" src="image/logo.png"
			alt=""></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myTrip">여행일정</a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainsearch">관광지</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainblog">블로그</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myPage">마이페이지</a>

	</div>
</header>
	<%
	User user = (User) session.getAttribute("user");
	%>


	<div class="container_wrap">
		<div class="container">
			<div class="title">계정 정보 수정</div>
			<form class="updateForm"
				action="<%=request.getContextPath()%>/myPage" method="post">
				<input type="text" placeholder="아이디" name="id" value="<%=user.getId()%>">
				<input type="password" placeholder="비밀번호" name="pw" value="<%=user.getPw()%>">
				<input type="text" placeholder="닉네임" name="nick" value="<%=user.getNick()%>">
				<button class="btn" type="submit">수정</button>
				<!-- 			<div> -->
				<!-- 				<label>아이디</label><br> <input type="text" name="id" -->
				<%-- 					value="<%=user != null ? user.getId() : ""%>" readonly> --%>
				<!-- 			</div> -->
				<!-- 			<div> -->
				<!-- 				<label>비밀번호</label><br> <input type="password" name="pw" -->
				<!-- 					placeholder="비밀번호" value=""> -->
				<!-- 			</div> -->
				<!-- 			<div> -->
				<!-- 				<label>닉네임</label><br> <input type="text" name="nick" -->
				<%-- 					placeholder="닉네임" value="<%=user != null ? user.getNick() : ""%>"> --%>
				<!-- 			</div> -->
				<!-- 			<button class="btn" type="submit">수정</button> -->
			</form>
			<div class="logout">
			<a href="<%=request.getContextPath()%>/logout">로그아웃</a>
			</div>
		</div>
	</div>
</body>
</html>
