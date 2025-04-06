<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>전자 알림장 시스템</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 100px auto;
	padding: 40px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h1 {
	margin-bottom: 30px;
	color: #222;
}

.btn {
	display: block;
	width: 80%;
	margin: 16px auto;
	padding: 14px 0;
	font-size: 16px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 8px;
	text-decoration: none;
	transition: background-color 0.2s ease;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<div class="container">
		<h1>전자 알림장 시스템</h1>

		<a href="Login" class="btn">로그인</a> <a href="studentList" class="btn">학생
			관리</a> <a href="parentsList" class="btn">학부모 관리</a>

	</div>

</body>
</html>
