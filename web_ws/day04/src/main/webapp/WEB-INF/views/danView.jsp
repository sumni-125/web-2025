<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.content{
width:200px;
border:1px solid black;
margin:0 auto;
padding: 10px;

}

h2{
text-align: center;
}
</style>
</head>
<body>

<% String dan  =( String)  request.getAttribute("dan"); %>

<h2>구구단</h2>
<div class="content">
<%= dan %>


</div>

</body>
</html>