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

<%
/*
	jsp에서 사용할 수 있는 저장소 : pageConext, request, session, application
	EL문법은 저장소에 저장된 내용들 EL문법으로 퓨ㅕㄴ하게 가져올 수 있다
*/

String str = "el로 출력이 되나요?? => 저장소에 저장된 것이 아니면 EL사용 못함";
//${str}로  EL문법을 사용해도 출력되지 않는다(이유는 저장소에 저장된것이 아니기떄문)

pageContext.setAttribute("str", str);

%>

${str} 
<!--%=str %  -->
</body>
</html>