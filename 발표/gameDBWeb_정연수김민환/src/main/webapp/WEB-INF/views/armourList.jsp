<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="game_item.Armour"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방어구 목록</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>방어력</th>
        <th>타입</th>
        <th>설명</th>
        <th>착용부위</th>
        <th>착용최소레벨</th>
    </tr>
    <%
        ArrayList<Armour> list = (ArrayList<Armour>) request.getAttribute("list");
        if (list != null && !list.isEmpty()) {
            for (Armour p : list) {
    %>
    <tr>
        <td><%= p.getArmourId() %></td>
        <td><%= p.getArmourName() %></td>
        <td><%= p.getArmourDef() %></td>
        <td><%= p.getArmourType() %></td>
        <td><%= p.getArmourDesc() %></td>
        <td><%= p.getArmourSlot() %></td>
        <td><%= p.getMinLevel() %></td>
    </tr>
			<%}%>
    <%}%> 
</table>
</body>
</html>