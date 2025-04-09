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

<% String[] music  =  (String[]) request.getAttribute("music"); %>


<%
   for( int i=0; i< music.length ; i++){
	    String m = music[i];  
	    out.println(m);
   }
%>

<%
   for( String  s : music){	     
	    out.println(s);
   }
%>




<h4> JSTL, EL 이용</h4>

<c:forEach  var="item" items="${music}">
${item} 
</c:forEach>





</body>
</html>