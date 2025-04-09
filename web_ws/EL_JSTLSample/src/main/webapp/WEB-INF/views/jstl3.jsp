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



<%  int kor  = (int) request.getAttribute("kor"); %>
<%= kor %>

<% if( kor >=90)  out.println("합격") ;%>

<h4> JSTL , EL 사용으로 변경하기 !!</h4>
${kor}  


<h4> jstl if문</h4>

<c:if test="${ kor >=90 }">
	합격
</c:if>


<h4>jstl 변수</h4>
<p>  c:set 변수를 만들면 자동으로 pageContext 저장소에 저장이됨  , EL표현을 사용할 수 있다.</p>
<c:set var="message" value="합격" />
${message}


<h4> 여러조건을 수행하는 구문  choose</h4>
<c:choose>
	<c:when test="${ kor >=90}"> 수</c:when>
	<c:when test="${ kor>=80 }"> 우</c:when>
	<c:when test="${ kor>=70 }"> 미 </c:when>
	<c:otherwise> 가</c:otherwise>
</c:choose>








 

</body>
</html>