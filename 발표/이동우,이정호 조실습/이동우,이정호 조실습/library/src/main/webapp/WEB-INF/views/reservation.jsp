<%@page import="library.Library"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel = "stylesheet" href = "css/library.css">
<!-- 
<style>
table {
	border: 1px solid black;
	text-align: center;
	margin: 0 auto;
}

h2 {
	text-align: center;
}

td {
	border: 1px solid black;
}

input {
	text-align: center;
	width: 100px;
	height: 50px;
	padding: 0;
}

 button {
	margin: 0 auto;
	text-align: center;
	width : 105px;
	height : 30px;
	border: none;
	cursor: pointer;
	background-color: #69B319;
	color: white;
	font-weight: bold;
} 

.resa {
	text-align: center;
	margin-bottom: 10px;
}

.resa a {
	color: black;
	text-decoration: none;
}
</style> -->
</head>
<body>

	<% ArrayList<Library> list = (ArrayList<Library> )request.getAttribute("library");
 	int total = list.size();
    int cols = 8; // 열
    int rows = 5; // 행
    int index = 0;
    %>
    
     <div class="header">
        <h1>자리 예약</h1>
        <div class="btn-group">
            <button onclick="location.href='/project/bookList'">도서 목록</button>
            <button onclick="location.href='/project/reviewList'">리뷰</button>
            <button onclick="location.href='/library/libraryhome'">자리 예약</button>
        </div>
    </div>
<!-- 	<h3><a href="/library/libaryseat">좌석확인</a></h3> -->
	<table>

		<% for (int i = 0; i < rows; i++) {   %>
		<tr>
			<%  for (int j = 0; j < cols; j++) { 
        if (index < total) {
            Library l = list.get(index++); %>

			<td class="<%= l.getSeat_status().equals("좌석X") ? "u" : "g" %>">
				<% if (l.getSeat_status().equals("좌석O")) { %>
				<form action="/library/libraryUpdate" method="post">
					<input type="hidden" name="id" value="<%= l.getSeat_id() %>">
					<input type="text" value="<%= l.getSeat_id() %>" readonly>
					<br>
					<button type="submit" class = "reserv">예약</button>
				</form> <% } else { %>
				<form action="/library/librarycancle" method="post">
					<input type="hidden" name="id" value="<%= l.getSeat_id() %>">
					<input type="text" value="<%= l.getSeat_id() %>" readonly>
					<br>
					<button type="submit" class = "cancle">취소</button>
				</form> <% } %>

			</td>
			<%   } else {  %>
			<!-- <td></td> -->
			<!-- 남은 칸은 빈칸 처리 -->
			<%  } 
  			 }  %>
		</tr>
		<% 
} 
%>

	</table>


</body>
</html>