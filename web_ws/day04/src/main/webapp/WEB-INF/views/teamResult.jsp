<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%

String path =  request.getContextPath();   //현재 프로젝트의 이름 얻어옴 , 프로젝트1개 => 한 개의 웹사이트 %>
 
 <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20140903_234%2Fth_media_1409671420114u4txC_JPEG%2F%25C0%25B0%25BD%25C9%25BF%25F8_%25B0%25B3%25B6%25CB%25C0%25CC_%25B1%25D7%25B8%25B2.jpg&type=a340">
 
 
 <link href="<%=path%>/css/team.css" rel="stylesheet">
<style>

  


</style> 
  
</head>
<body>
 

<% 
HashMap<Integer, HashSet<String >>   map  =(HashMap<Integer, HashSet<String >>  ) request.getAttribute("result");  

%>



<h2>^^같은 조 된거 축하합니다!!^^</h2>
<div class="show">

  <%  for(int i=1; i<= map.size() ;i++){	  
		  HashSet<String> set  = map.get(i);	
		  
		  out.println(  i  + "조");
		  Iterator<String>  team= set.iterator();
		  while( team.hasNext()){
			  out.println( team.next());
		  } 
		  
		  out.println("<br>");
     }
%>
</div>

</body>
</html>