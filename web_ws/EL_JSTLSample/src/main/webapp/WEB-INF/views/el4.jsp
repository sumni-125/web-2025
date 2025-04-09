<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h4>  저장소 값 꺼내는 순서(찾는 순서)  </h4>
 <h4>  저장소에서 저장된 값을 꺼내올 때 어떤 순서대로 찾는지 알아두자 ! </h4>   
 
   pageContext  -> request - > session  -> application   순으로 찾는다.  
 
 

   <%
      pageContext.setAttribute("id", "id page");
      request.setAttribute("id",  " id request");
      session.setAttribute("id", "id session");
      application.setAttribute("id", "id application");    
   
   %>


${id}
<h4> 저장소별로 값을 꺼내기 </h4>


${ pageScope.id}
${ requestScope.id} 
${ sessionScope.id}
${ applicationScope.id}

















</body>
</html>