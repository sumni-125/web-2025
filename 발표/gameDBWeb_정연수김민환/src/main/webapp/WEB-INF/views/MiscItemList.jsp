<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="game_item.MiscItem"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소모품</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>타입</th>
        <th>설명</th>
        <th>저장가능여부</th>
    </tr>
    <%
        ArrayList<MiscItem> list = (ArrayList<MiscItem>) request.getAttribute("list");
        if (list != null && !list.isEmpty()) {
            for (MiscItem p : list) {
    %>
    <tr>
        <td><%= p.getMiscId() %></td>
        <td><%= p.getMiscName() %></td>
        <td><%= p.getMiscType() %></td>
        <td><%= p.getMiscDesc() %></td>
        <td><%= p.getStackable() %></td>
    </tr>
			<%}%>
    <%}%> 
</table>
</body>
</html>