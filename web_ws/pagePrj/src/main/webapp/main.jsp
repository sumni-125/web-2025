<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

메인화면입니다 . <br>
<a href="<%=request.getContextPath()%>/list.page?p=1">게시판진짜1</a> <br>
<a href="<%=request.getContextPath()%>/list2.page?p=1">게시판진짜2</a><br>
<a href="<%=request.getContextPath()%>/list3.page?p=1">게시판진짜3</a><br>
<a href="<%=request.getContextPath()%>/paging.jsp?p=1">게시판가짜</a>

</body>
</html>