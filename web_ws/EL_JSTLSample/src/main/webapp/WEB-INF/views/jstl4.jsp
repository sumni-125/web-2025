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


<h4> </h4>
<c:forEach   var="i" begin="1"  end="10"  > 
${i}
</c:forEach>


<c:forEach var="i" begin="1" end="9">
    2 x ${i} = ${2 * i} <br>
</c:forEach>



<h4>전체구구단</h4>
<c:forEach   var="i" begin="1"  end="10"  >
 
	 <c:forEach   var="j" begin="1"  end="10"  > 
	 	      ${ i*j }  <br>
	</c:forEach>
    <br>
</c:forEach>
</body>
</html>