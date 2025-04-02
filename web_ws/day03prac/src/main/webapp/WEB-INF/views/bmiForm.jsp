<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day03prac/bmiService" method="post">
		<table>
			<tr>
				<td>키</td>
				<td><input type="text" name="height"></td>

			</tr>
			<tr>
				<td>몸무게</td>
				<td><input type="text" name="weight"></td>

			</tr>
			<tr>

				<td colspan="2"><button>계산하기</button></td>

			</tr>

		</table>
	</form>
</body>
</html>