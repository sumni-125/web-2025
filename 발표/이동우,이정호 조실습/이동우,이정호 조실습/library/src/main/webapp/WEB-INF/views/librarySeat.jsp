<%@page import="library.Library"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 보기</title>

<style>
h2 {
	text-align: center;
}

 h3{
 text-align: center;
 }

table {
	border-collapse: collapse;
	margin: 0 auto;
	border : 3px solid black;
}

th, td {
	border: 2px solid black;
	padding: 20px;
	text-align: center;
}

a {
	text-decoration: none;
	color: black;
	
}

.c{
	background-color : #d3d3d3;
	pointer-events: none;
	color : gray;
}

.b{
	font-weight: bold;
}

</style>
</head>
<body>

	<h2>좌석확인</h2>
	
	<h3><a href="/library/libraryhome">예약페이지 이동</a></h3>

	<% 
    ArrayList<Library> list = (ArrayList<Library>) request.getAttribute("library"); 
    int total = list.size();
    int cols = 10; // 열
    int rows = 5; // 행
    int index = 0;
%>

	<table>
		<% 
for (int i = 0; i < rows; i++) { 
%>
		<tr>
			<% 
    for (int j = 0; j < cols; j++) { 
        if (index < total) {
            Library l = list.get(index++);
    %>
			<td <% if(l.getSeat_status().equals("좌석X")){ %> class="c">
				<% }else { %> class = "b"> <% }
      
        	%> <%= l.getSeat_id() %> </br> <%=l.getSeat_status() %>
			</td>
			<% 
        } else {
    %>
			<td></td>
			<!-- 남은 칸은 빈칸 처리 -->
			<% 
        } 
    } 
    %>
		</tr>
		<% 
} 
%>
	</table>
	

</body>
</html>