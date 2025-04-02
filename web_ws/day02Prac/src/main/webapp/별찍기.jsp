<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>별찍기</h1>
<%
String cnt_ = request.getParameter("cnt");
int cnt = Integer.parseInt(cnt_);


for (int i=1; i<=cnt; i++) {
    out.println("*");
}


%>

</body>
</html>