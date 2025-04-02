<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hello world</h1>
<!-- 스크립트릿 :  자바코드 작성함 -->
<%  
	String name = request.getParameter("name");
	
	if( name == null){
		out.print(" guest hi~~~");  
	}else{
		out.print(name +"hi~~~");
	}
%>

<!--  표현식   out.print()로 바뀐다.-->
<%=name %>

</body>
</html>