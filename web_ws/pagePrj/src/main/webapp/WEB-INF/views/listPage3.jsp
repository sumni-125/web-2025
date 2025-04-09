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

 
 <c:set var="path"  value="<%=request.getContextPath() %>"/>
 
 <c:forEach  var="item" items="${list1}">
	 <tr>
	<td>${item.m_id }</td>
	<td>${item.m_name }</td>
	<td>${item.m_pw}</td>
	<td>${item.m_birthday }</td>
	<td>${item.m_point }</td>
	<td>${item.m_tel}</td>
	<td></td>
	</tr>
 </c:forEach> 
 
 </table>
   
 

<c:if test="${paging.currentGrp > 1}">
    <a href="/pagePrj/list3.page?p=${paging.grpStartPage - 1}">[ 이전 ]</a>
</c:if>


<c:forEach  var="i"  begin="${paging.grpStartPage}" end="${paging.grpEndPage}"> 
    <a href="/pagePrj/list3.page?p=${i}">[ ${i} ]</a>      
</c:forEach>

 

<c:if test="${paging.grpEndPage <  paging.totalPage}">
    <a href="/pagePrj/list3.page?p=${paging.grpEndPage+1}">[ 다음 ]</a>
</c:if>
 	 

 
	
</body>
</html>