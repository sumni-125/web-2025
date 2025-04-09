<%@page import="day08Prac.PageHandler"%>
<%@page import="day08Prac.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Member> list =(ArrayList<Member>) request.getAttribute("list"); %>

<%for(Member m:list) {%>
<p><%=m.getM_name() %> <%=m.getM_id() %></p>
<%} %>



<% PageHandler paging =(PageHandler) request.getAttribute("paging"); %>

<!-- 이전 -->

<%
if(paging.getGrpStartPage() > 1){
	
	%>
	<a href="/day08Prac/list?p=<%=paging.getGrpStartPage()-1 %>">[ 이전 ]</a>
	<%
}
%>

<%for(int i=paging.getGrpStartPage();i<=paging.getGrpEndPage();i++){ %>

<a href="/day08Prac/list?p=<%=i%>">[ <%=i %> ]</a>

<%} %>

<!-- 다음 -->
<%
if(paging.getGrpEndPage()<paging.getTotalPage()){
	
	%>
	<a href="/day08Prac/list?p=<%=paging.getGrpEndPage()+1 %>">[ 다음 ]</a>
	<%
}
%>

</body>
</html>