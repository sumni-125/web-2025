<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String animal =(String) session.getAttribute("animal"); 
String flower =(String) session.getAttribute("flower"); 

%>
<h2>설문결과 안내</h2>
<%=animal %>와
<%=flower %>를 좋아하는군요 !!
</body>
</html>