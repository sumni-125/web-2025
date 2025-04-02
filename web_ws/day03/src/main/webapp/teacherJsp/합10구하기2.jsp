<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 사용자가 원하는 수만큼 더하기</h2>

 <p> request 내장객체가 제공됩니다. </p>


<% String su_ = request.getParameter("su");
   if( su_ == null) return;   
   int su = Integer.parseInt( su_);
%>
 
 <h2>1~어떤수 까지 출력</h2>
<%

 int sum =0;
 for(  int  i=1 ; i<=su ;i++){
	  sum += i;
	  out.println( i +"<br>");
 }  
 out.println( sum);
%>
 
</body>
</html>