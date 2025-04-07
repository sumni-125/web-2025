<%@page import="game_item.Weapon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>무기 목록</title></head>
<body>

<table border="1">
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>공격력</th>
        <th>타입</th>
        <th>설명</th>
        <th>착용최소레벨</th>
    </tr>
    <%
        ArrayList<Weapon> list = (ArrayList<Weapon>) request.getAttribute("list");
        if (list != null && !list.isEmpty()) {
            for (Weapon p : list) {
    %>
    <tr>
        <td><%= p.getWeaponId() %></td>
        <td><%= p.getWeaponName() %></td>
        <td><%= p.getWeaponAtk() %></td>
        <td><%= p.getWeaponType() %></td>
        <td><%= p.getWeaponDesc() %></td>
        <td><%= p.getMinLevel() %></td>
    </tr>
			<%}%>
    <%}%> 
</table>
    
</body>
</html>
