<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrap">
		<div class="log-wrap">
			<form class="login-form" action="/Board/login" method="post">
				<h2>Login</h2>
				<label for="id">ID</label> 
				<input type="text" name="id" id="id" required> 
				<label for="pwd">Password</label> <input type="password" name="pw" id="pwd" required>
				<button>로그인하기</button>
			</form>
		</div>
	</div>
</body>
</html>