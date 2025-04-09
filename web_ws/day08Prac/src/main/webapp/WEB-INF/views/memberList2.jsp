<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="item" items="${list}">
<!-- 아이템에 리스트객체를 저장?하고?? getter 로 가져옴 -->
${item.m_id } ${item.m_name } <br>

</c:forEach>

</body>
</html>