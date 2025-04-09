<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>


*{

padding:0px;
margin:0px;

}
.login_wrap{

width:400px; 
margin: 200px auto;
border:1px solid black;
padding:20px;

}
.info{
 
 width:350px; 
 padding:20px;
 margin:0px auto;
 

}

 

.info input{
   width:100%;
   height:40px;
   margin-top: 5px;
   border:0px;
   background-color:#CCCCCC;
   color:white;
   
 
}

.info button{
   width:100%;
   height:40px;
   margin-top: 5px;  
   border:0px;
   
 
}
</style>


<script>
  function loginCheck(){
	  document.frm.submit();
  }

</script>
</head>
<body>


<% 
String message = request.getParameter("message");
 
if( message != null){ 
    out.println( URLDecoder.decode(message, "utf-8"));	
}
 %>
<form name="frm" action="/sessionLogin/login" method="post">
  <div class="login_wrap">	
	<div class="info">
		<input type="text"  placeholder="ID"  name="id">
		<input type="text" placeholder="PW"  name="pwd">
		<button>Login</button>	
	</div>
</div>
</form>
</body>
</html>