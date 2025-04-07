<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<%
String error = request.getParameter("error");
if ("1".equals(error)) {
%>
<script>
	alert("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
</script>
<%
}
%>

<head>
<title>로그인</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f2f5;
	margin: 0;
	padding: 0;
}

.login-container {
	max-width: 400px;
	margin: 100px auto;
	padding: 40px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #333;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
}

input[type="text"], input[type="password"], select {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 6px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 14px;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 12px;
	border-radius: 6px;
	font-size: 15px;
	cursor: pointer;
	width: 100%;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

.back-link {
	display: block;
	width: fit-content;
	margin: 30px auto 0;
	color: #555;
	text-decoration: none;
	font-size: 14px;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-radius: 6px;
	background-color: #f2f2f2;
	transition: background-color 0.2s ease;
}

.back-link:hover {
	background-color: #e0e0e0;
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>로그인</h2>
		<form action="Login" method="post">
			<label for="id">아이디</label> <input type="text" name="id" required>

			<label for="pw">비밀번호</label> <input type="password" name="pw"
				required> <label for="role">역할 선택</label> <select
				name="role" required>
				<option value="teacher">선생님</option>
				<option value="student">학생</option>
				<option value="parent">학부모</option>
			</select> <input type="submit" value="로그인">
		</form>

		<a href="home" class="back-link">← 홈으로 돌아가기</a>
	</div>
</body>
</html>
