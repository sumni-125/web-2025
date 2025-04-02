<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사</title>
<style>
	.box {
        width: 250px;
        height: 250px;
        background-color: aqua;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 20px;
        font-weight: bold;
        
        margin: 0 auto;
        margin-top: 200px;
        transition: 1s;
    }

    .box:hover {
    	width: 500px;
    	height: 500px;
        background-color: blue;
        color: white;
        font-size: 30px;
        font-weight: bold;
        
        border-radius: 50%;
    }
</style>
</head>
<body>

<% String msg = (String) request.getAttribute("hello"); %>

<div class = "box">
<%=msg %>
</div>
</body>
</html>