<%@page import="player.Player"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모험가 명부</title>    
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            background-color: #111;
            background-image: url('https://cdnjs.cloudflare.com/ajax/libs/simple-icons/3.0.1/ghost.svg');
            background-size: cover;
            background-position: center;
            font-family: 'Times New Roman', serif;
            color: #d9c08c;
            position: relative;
            min-height: 100vh;
            overflow-x: hidden;
        }
        
        body::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
            z-index: -1;
        }
        
        .tavern-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            position: relative;
        }
        
        .header {
            text-align: center;
            padding: 40px 0;
            position: relative;
        }
        
        .header h1, .header h2 {
            color: #e2c792;
            font-size: 42px;
            text-shadow: 0 3px 5px rgba(0, 0, 0, 0.8);
            font-weight: normal;
            letter-spacing: 3px;
            margin-bottom: 10px;
            position: relative;
            display: inline-block;
        }
        
        .header h1::before,
        .header h1::after,
        .header h2::before,
        .header h2::after {
            content: '★';
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            color: #92734a;
            font-size: 24px;
        }
        
        .header h1::before,
        .header h2::before {
            left: -40px;
        }
        
        .header h1::after,
        .header h2::after {
            right: -40px;
        }
        
        .header::after {
            content: "";
            position: absolute;
            bottom: 20px;
            left: 50%;
            transform: translateX(-50%);
            width: 300px;
            height: 2px;
            background: linear-gradient(to right, transparent, #92734a, transparent);
        }
        
        .content-box {
            background-color: #2a1a0a;
            border: 8px solid #3d2b17;
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(255, 200, 100, 0.3),
                        inset 0 0 30px rgba(0, 0, 0, 0.5);
            padding: 30px;
            position: relative;
            background-image: url('https://cdnjs.cloudflare.com/ajax/libs/simple-icons/3.0.1/ghost.svg');
            background-blend-mode: overlay;
            background-size: cover;
            margin-bottom: 40px;
        }
        
        .content-box::before {
            content: '';
            position: absolute;
            top: 10px;
            left: 10px;
            right: 10px;
            bottom: 10px;
            border: 2px solid #92734a;
            pointer-events: none;
        }
        
        .search-form {
            margin: 0 auto 20px;
            max-width: 500px;
            padding: 15px;
            background-color: rgba(58, 40, 23, 0.8);
            border: 2px solid #92734a;
            border-radius: 5px;
            display: flex;
            justify-content: center;
            position: relative;
        }
        
        .search-form input[type="text"] {
            padding: 10px;
            border: 2px solid #92734a;
            background-color: rgba(0, 0, 0, 0.2);
            color: #d9c08c;
            font-family: 'Times New Roman', serif;
            width: 70%;
            margin-right: 10px;
        }
        
        .search-form button {
            padding: 10px 15px;
            background-color: #4d3b27;
            border: 2px solid #92734a;
            color: #e2c792;
            cursor: pointer;
            transition: all 0.3s;
        }
        
        .search-form button:hover {
            background-color: #5c4b37;
            color: #ffe6b3;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            color: #d9c08c;
            background-color: rgba(42, 26, 10, 0.6);
        }
        
        th, td {
            padding: 12px 15px;
            text-align: left;
            border: 1px solid #92734a;
        }
        
        th {
            background-color: #3d2b17;
            color: #e2c792;
            font-weight: normal;
            letter-spacing: 1px;
        }
        
        tr:nth-child(even) {
            background-color: rgba(58, 40, 23, 0.4);
        }
        
        tr:hover {
            background-color: rgba(92, 75, 55, 0.4);
        }
        
        .action-buttons {
            display: flex;
            justify-content: space-around;
        }
        
        .edit-btn, .delete-btn {
            display: inline-block;
            padding: 5px 10px;
            margin: 2px;
            border: 1px solid #92734a;
            text-decoration: none;
            text-align: center;
            font-size: 14px;
            transition: all 0.3s;
        }
        
        .edit-btn {
            background-color: rgba(77, 131, 77, 0.6);
            color: #d5e8d5;
        }
        
        .delete-btn {
            background-color: rgba(166, 76, 76, 0.6);
            color: #f4d4d4;
        }
        
        .edit-btn:hover {
            background-color: rgba(77, 151, 77, 0.8);
        }
        
        .delete-btn:hover {
            background-color: rgba(186, 86, 86, 0.8);
        }
        
        .footer {
            text-align: center;
            margin-top: 40px;
            padding: 20px;
            color: #92734a;
            font-size: 14px;
            border-top: 1px solid rgba(146, 115, 74, 0.3);
        }
        
        .torch {
            position: absolute;
            width: 12px;
            height: 12px;
            background: #ffc773;
            border-radius: 50%;
            box-shadow: 0 0 20px #ffc773, 0 0 40px #ffc773;
            animation: flicker 4s infinite alternate;
        }
        
        .torch-left {
            top: 30px;
            left: 30px;
        }
        
        .torch-right {
            top: 30px;
            right: 30px;
        }
        
        @keyframes flicker {
            0%, 100% {
                opacity: 1;
                box-shadow: 0 0 20px #ffc773, 0 0 40px #ffc773;
            }
            25% {
                opacity: 0.8;
                box-shadow: 0 0 15px #ffc773, 0 0 30px #ffc773;
            }
            50% {
                opacity: 0.9;
                box-shadow: 0 0 25px #ffc773, 0 0 45px #ffc773;
            }
            75% {
                opacity: 0.7;
                box-shadow: 0 0 10px #ffc773, 0 0 25px #ffc773;
            }
        }
        
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #3d2b17;
            border: 2px solid #92734a;
            color: #e2c792;
            text-decoration: none;
            transition: all 0.3s;
            text-align: center;
        }
        
        .back-link:hover {
            background-color: #4d3b27;
            color: #ffe6b3;
        }
        
        .decoration {
            position: absolute;
            font-size: 24px;
            color: #92734a;
            opacity: 0.5;
        }
        
        .deco1 { top: 100px; left: 50px; }
        .deco2 { top: 200px; right: 80px; }
        .deco3 { bottom: 150px; left: 30px; }
        .deco4 { bottom: 100px; right: 60px; }
    </style>
</head>
<body>
    <div class="tavern-container">
        <div class="decoration deco1">✦</div>
        <div class="decoration deco2">✧</div>
        <div class="decoration deco3">✦</div>
        <div class="decoration deco4">✧</div>
        
        <div class="header">
            <h2>모험가 명부</h2>
        </div>
        
        <div class="content-box">
            <div class="torch torch-left"></div>
            <div class="torch torch-right"></div>
            
            <!-- 검색 폼 -->
            <form method="get" action="playerslist" class="search-form">
                <input type="text" name="keyword" placeholder="ID 또는 이름 검색">
                <button type="submit">검색</button>
            </form>
            
            <table>
                <tr>
                    <th>ID</th>
                    <th>이름</th>
                    <th>레벨</th>
                    <th>골드</th>
                    <th>STR</th>
                    <th>DEX</th>
                    <th>INT</th>
                    <th>가입일</th>
                    <th>관리</th>
                </tr>
                <%
                    ArrayList<Player> list = (ArrayList<Player>) request.getAttribute("list");
                    if (list != null && !list.isEmpty()) {
                        for (Player p : list) {
                %>
                <tr>
                    <td><%= p.getPlayerId() %></td>
                    <td><%= p.getPlayerName() %></td>
                    <td><%= p.getPlayerLevel() %></td>
                    <td><%= p.getPlayerGold() %></td>
                    <td><%= p.getPlayerStr() %></td>
                    <td><%= p.getPlayerDex() %></td>
                    <td><%= p.getPlayerInt() %></td>
                    <td><%= p.getCreatedDate() %></td>
                    <td class="action-buttons">
                        <a href="PlayerUpdate?playerId=<%= p.getPlayerId() %>" class="edit-btn">수정</a>
                        <a href="javascript:confirmDelete('<%= p.getPlayerId() %>')" class="delete-btn">삭제</a>
                    </td>
                </tr>
                <% 
                        }
                    } else { 
                %>
                <tr><td colspan="9">검색 결과가 없습니다.</td></tr>
                <% } %>
            </table>
            
            <div style="text-align: center;">
                <a href="/gameDBWeb/index" class="back-link">선술집으로 돌아가기</a>
            </div>
        </div>
        
        <div class="footer">
            <p>© 2025 모험가의 아이템 데이터베이스 | 모든 권리는 선술집 주인에게 있습니다.</p>
        </div>
    </div>

    <script>
        function confirmDelete(playerId) {
            if (confirm("정말로 이 모험가를 명부에서 삭제하시겠습니까?")) {
                window.location.href = "PlayerDelete?playerId=" + playerId;
            }
        }
    </script>
</body>
</html>