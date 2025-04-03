<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 width:300px;
 border:1px solid black;
 border-collapse: collapse;
 margin:0 auto;
}

td{
 border:1px solid black;
}

td:nth-child(1) {
text-align: center;
	
}

h2{
text-align: center;
}
</style>
</head>
<body>

	<h2>로그인</h2>
	<form name="frm"  action="/day04/login"  method="post">
	
	
	<table>
		<tr>
		<td>아이디</td>
		<td><input type="text" name="userid"></td>
		</tr>
		
		<tr>
		<td>비밀번호</td>
		<td><input type="text" name="userpw"></td>
		</tr>
		
		<tr>
		<td colspan="2">
		<button>로그인</button>
		</td>
		 
		</tr>
	
	</table>
	</form>
</body>
</html>