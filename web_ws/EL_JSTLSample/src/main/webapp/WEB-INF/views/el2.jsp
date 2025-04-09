<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String result  = (String)request.getAttribute("data2"); %>
<%= result %>


<h2> EL 사용</h2>
${data2}



<% String str="hi EL"; %>
<%=str%>
<h2> str변수의 값이 EL을 통해서 출력이 될까?</h2>


<h2>  jsp에서 사용할 수 있는 저장소 </h2>
<ul>
	<li>pageContext : jsp 페이지 내에서만 사용할 수 있는 저장소 </li>
	<li>request : 하나의 요청이 공유하는 저장소</li>
	<li>session : 하나의 사용자가 공유하는 저장소  서버가 사용자별로 저장소를 제공함 </li>
	<li>application : 모든 서블릿이 사용할 수 있는 저장소 , 설정</li>
</ul>


<h2> pageContext  저장소 사용하기</h2>
<% pageContext.setAttribute("msg", "jsp 페이지내에서만 사용가능한 저장소, EL을 사용하기 위해서는 저장소에 저장되어야 한다.");  %>

<p>결과==></p>
${msg}


</body>
</html>