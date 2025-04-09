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
${data }

<!-- jsp에서 사용할 수 있는 저장소 : pageContext(jsp에 있는 저장소), request, session, application -->

<!-- 저장된 값을 가져올 때 모든 저장소를 다 확인함, 순서가 있음 pageContext -> request -> session -> application -->
<!--  -->

<%

pageContext.setAttribute("id", "id pageContext");
request.setAttribute("id", "id request");
session.setAttribute("id", "id session");
application.setAttribute("id", "id application");

%>
<h2>결과</h2>
<h2>${id}</h2>
<h2>${sessionScope.id }</h2>
<h2>${requestScope.id}</h2>
<h2>${applicationScope.id }</h2>
<h2>${pageScope.id }</h2>

</body>
</html>