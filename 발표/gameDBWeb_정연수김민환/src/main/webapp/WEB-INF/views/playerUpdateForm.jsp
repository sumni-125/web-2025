<%@page import="player.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>플레이어 정보 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h2 {
        color: #333;
    }
    .form-container {
        max-width: 600px;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[readonly] {
        background-color: #f5f5f5;
    }
    .button-group {
        margin-top: 20px;
    }
    button {
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-right: 10px;
    }
    .submit-btn {
        background-color: #4CAF50;
        color: white;
    }
    .cancel-btn {
        background-color: #f44336;
        color: white;
    }
</style>
</head>
<body>
<h2>플레이어 정보 수정</h2>

<%
    Player player = (Player) request.getAttribute("player");
    if (player == null) {
%>
    <p>플레이어 정보를 찾을 수 없습니다.</p>
    <a href="playerslist">플레이어 목록으로 돌아가기</a>
<%
    } else {
%>
<div class="form-container">
    <form action="PlayerUpdate" method="post">
        <div class="form-group">
            <label for="playerId">플레이어 ID:</label>
            <input type="text" id="playerId" name="playerId" value="<%= player.getPlayerId() %>" readonly>
        </div>
        
        <div class="form-group">
            <label for="playerName">이름:</label>
            <input type="text" id="playerName" name="playerName" value="<%= player.getPlayerName() %>" required>
        </div>
        
        <div class="form-group">
            <label for="playerLevel">레벨:</label>
            <input type="number" id="playerLevel" name="playerLevel" value="<%= player.getPlayerLevel() %>" min="1" required>
        </div>
        
        <div class="form-group">
            <label for="playerGold">골드:</label>
            <input type="number" id="playerGold" name="playerGold" value="<%= player.getPlayerGold() %>" min="0" required>
        </div>
        
        <div class="form-group">
            <label for="playerStr">STR:</label>
            <input type="number" id="playerStr" name="playerStr" value="<%= player.getPlayerStr() %>" min="1" required>
        </div>
        
        <div class="form-group">
            <label for="playerDex">DEX:</label>
            <input type="number" id="playerDex" name="playerDex" value="<%= player.getPlayerDex() %>" min="1" required>
        </div>
        
        <div class="form-group">
            <label for="playerInt">INT:</label>
            <input type="number" id="playerInt" name="playerInt" value="<%= player.getPlayerInt() %>" min="1" required>
        </div>
        
        <div class="form-group">
            <label>가입일:</label>
            <input type="text" value="<%= player.getCreatedDate() %>" readonly>
        </div>
        
        <div class="button-group">
            <button type="submit" class="submit-btn">저장</button>
            <button type="button" class="cancel-btn" onclick="location.href='playerslist'">취소</button>
        </div>
    </form>
</div>
<% } %>
</body>
</html>