<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>EL산술연산</h4>

${10+20}
${20-10}
${20 /10}
${20 %10}



<h4>관계연산자</h4>

${ 10 eq 11} <br>
${ 10 eq 10 }<br>
 
${ 10 == 10 }<br>
${ 10 > 5 }

<h4> EL논리연산자</h4>

${  true  && true }
${ 5>3 &&  10>20 }
${ 5>3 ||  10>20 }


<% pageContext.setAttribute("title", "EL연산자  empty"); %>

${title}
${ empty title }
${ not empty title }
${  empty title ?"내용없어" : "내용있어" }
<br>
${title2 }
${ empty title2 }
${ not empty title2 }





</body>
</html>