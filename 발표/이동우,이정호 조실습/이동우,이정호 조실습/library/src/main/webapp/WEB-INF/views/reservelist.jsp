<%@page import="library.Library"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 완료</title>
<style>
	body {
		font-family: Arial, sans-serif;
		text-align: center;
		padding-top: 50px;
		background-color: #f4f4f4;
	}

	h2 {
		color: #333;
	}

	p {
		font-size: 20px;
		margin-bottom: 30px;
	}

	a {
		display: inline-block;
		padding: 10px 20px;
		background-color: #69B319;
		color: white;
		text-decoration: none;
		border-radius: 5px;
		font-weight: bold;
	}

	a:hover {
		background-color: #558f13;
	}
</style>
</head>
<body>

	<% if (request.getAttribute("msg") != null) { %>
	<script>
		alert('<%= request.getAttribute("msg") %>');
	</script>
	<% } %>

	<h2>예약이 완료되었습니다!</h2>
	<p>좌석이 성공적으로 예약되었습니다.</p>

	<a href="/library/libraryhome">홈으로 돌아가기</a>

</body>
</html>