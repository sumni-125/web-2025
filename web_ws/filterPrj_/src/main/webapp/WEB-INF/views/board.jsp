<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>글쓰기</h2>

<form  action="<%=request.getContextPath()%>/board.do"  method="post">
	<input type="text"  name="title">
	<textarea rows="5" cols="10"  name="content"></textarea>
	<button>등록</button>
</form>

</body>
</html>