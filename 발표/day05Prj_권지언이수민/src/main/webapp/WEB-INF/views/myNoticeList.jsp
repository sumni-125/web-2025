<%@page import="teamproject.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td{
border:1px solid black;
border-collapse:collapse;
}
</style>

</head>
<body>

<% ArrayList<Notice> list =(ArrayList<Notice>)  request.getAttribute("list"); %>
<table>

<tr>
<td>등록번호</td>
<td>제목</td>
<td>등록일자</td>

</tr>
<%for(Notice n: list){ %>
<tr>
<td><%=n.getNotices_cd() %></td>
<td><%=n.getTitle() %></td>
<td><%=n.getNotices_description() %></td>
<td><%=n.getWrite_date() %></td>
<td><button onclick="location.href='/day05Prj/updateNotice?notices_cd=<%=n.getNotices_cd()%>'">수정하기</button>
</td>
<td><button onclick="location.href='/day05Prj/deleteNotice?notices_cd=<%=n.getNotices_cd()%>'">삭제하기</button>
</td>
</tr>

<%} 

Notice notice =list.get(1);
%>

</table>

<a href="/day05Prj/insertNotice?teacher_cd=<%=notice.getTeacher_cd() %>" class="back-link">알림장 쓰기</a>
</body>
</html>