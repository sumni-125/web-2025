<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="page.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="page.MemberDao" %>
<%@ page import="page.PageHandler" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>

<% ArrayList<Member>  list =  (ArrayList<Member>)request.getAttribute("list1") ; 
   PageHandler handler  = (PageHandler)request.getAttribute("paging");

for( Member m: list) {
%>

<tr>
<td> <%=m.getM_id() %></td>
<td> <%=m.getM_name() %></td>
<td> <%=m.getM_pw() %></td>
<td> <%=m.getM_birthday() %></td>
<td> <%=m.getM_tel() %></td>
<td> <%=m.getM_point() %></td>
<td> <%=m.getM_grade() %></td>
</tr>

<%} %>
</table>
 <%
  
	 
	 if( handler.getCurrentGrp() >1){	%>		 
	     <a href="/pagePrj/list2.page?p=<%=handler.getGrpStartPage()-1%>">[ 이전 ]</a>	    
	 <%   
	 } 
	 
	 for( int i= handler.getGrpStartPage()  ; i<= handler.getGrpEndPage() ;i++){		 
	 %>
		  <a href="/pagePrj/list2.page?p=<%=i%>">[  <%=i %> ]</a> 
     <%          
	 }
	 
	 if( handler.getGrpEndPage() <  handler.getTotalPage() ){
	     
	 %>	       
		   <a href="/pagePrj/list2.page?p=<%=handler.getGrpEndPage()+1%>">[ 다음 ]</a>  
	<% }
	%>
	
</body>
</html>