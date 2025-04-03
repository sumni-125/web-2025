<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.ball{
width : 100px;
height : 100px;
border-radius: 50%;
border : 1px solid black;
margin-right: 20px;
line-height: 100px;
text-align: center;
}


body {
display: flex;
}


</style>
</head>
<body>

<%int[] lotto = (int[]) request.getAttribute("lotto"); %>
<h2>로또서비스</h2>


<%for(int i   : lotto){ %>
<div class="ball">
      <%=i %>

</div>


<%} %>


</body>
</html>