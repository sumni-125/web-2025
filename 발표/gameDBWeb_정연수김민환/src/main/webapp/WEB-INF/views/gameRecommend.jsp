<%@page import="java.util.ArrayList"%>
<%@page import="gameDBWeb.GameWeb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모험가의 장비 추천</title>
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
            overflow-x: hidden;
            min-height: 100vh;
            padding: 20px;
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
        
        .itemRecommendBody {
            background-color: #2a1a0a;
            border: 8px solid #3d2b17;
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(255, 200, 100, 0.3),
                        inset 0 0 30px rgba(0, 0, 0, 0.5);
            padding: 30px;
            max-width: 900px;
            margin: 30px auto;
            position: relative;
            background-image: url('https://cdnjs.cloudflare.com/ajax/libs/simple-icons/3.0.1/ghost.svg');
            background-blend-mode: overlay;
            background-size: cover;
        }
        
        .itemRecommendBody::before {
            content: '';
            position: absolute;
            top: 10px;
            left: 10px;
            right: 10px;
            bottom: 10px;
            border: 2px solid #92734a;
            pointer-events: none;
        }
        
        h1 {
            color: #e2c792;
            text-align: center;
            margin-bottom: 25px;
            font-size: 32px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            font-weight: normal;
            letter-spacing: 2px;
            position: relative;
            padding-bottom: 15px;
        }
        
        h1::after {
            content: "";
            position: absolute;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 200px;
            height: 2px;
            background: linear-gradient(to right, transparent, #92734a, transparent);
        }
        
        .tab-container {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        
        .tab-button {
            background-color: #3d2b17;
            color: #d9c08c;
            border: 2px solid #92734a;
            padding: 10px 20px;
            margin: 0 5px;
            cursor: pointer;
            transition: all 0.3s;
            font-family: 'Times New Roman', serif;
            font-size: 16px;
            position: relative;
            overflow: hidden;
        }
        
        .tab-button::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.1);
            transition: all 0.3s;
        }
        
        .tab-button:hover::before {
            left: 0;
        }
        
        .tab-button:hover {
            background-color: #4d3b27;
            color: #ffe6b3;
            box-shadow: 0 0 10px rgba(255, 200, 100, 0.3);
        }
        
        .tab-button.active {
            background-color: #5c3f1d;
            color: #ffe6b3;
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.5);
        }
        
        .tab-content {
            display: none;
        }
        
        .tab-content.active {
            display: block;
        }
        
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            margin-bottom: 20px;
            border: 2px solid #92734a;
        }
        
        th, td {
            text-align: left;
            padding: 12px 15px;
            border-bottom: 1px solid #5c3f1d;
        }
        
        th {
            background-color: #3d2b17;
            color: #e2c792;
            font-weight: bold;
            text-shadow: 0 1px 2px rgba(0, 0, 0, 0.8);
            letter-spacing: 1px;
            border-bottom: 2px solid #92734a;
        }
        
        td {
            background-color: rgba(58, 40, 23, 0.5);
            color: #d9c08c;
        }
        
        tr:nth-child(even) td {
            background-color: rgba(46, 32, 18, 0.5);
        }
        
        tr:hover td {
            background-color: rgba(71, 49, 28, 0.7);
        }
        
        .class-header {
            background-color: #2a1a0a;
            color: #ffd700;
            text-align: center;
            font-size: 18px;
            padding: 15px;
            margin-top: 20px;
            margin-bottom: 10px;
            border: 1px solid #92734a;
            text-shadow: 0 1px 3px rgba(0, 0, 0, 0.9);
            position: relative;
        }
        
        .class-header::before,
        .class-header::after {
            content: '✦';
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            color: #92734a;
        }
        
        .class-header::before {
            left: 20px;
        }
        
        .class-header::after {
            right: 20px;
        }
        
        .home-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 25px;
            background-color: #5c3f1d;
            color: #e2c792;
            text-decoration: none;
            border: 2px solid #92734a;
            text-align: center;
            font-size: 16px;
            transition: all 0.3s;
            position: relative;
            overflow: hidden;
        }
        
        .home-link::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.1);
            transition: all 0.3s;
        }
        
        .home-link:hover::before {
            left: 0;
        }
        
        .home-link:hover {
            background-color: #7c5734;
            color: #ffe6b3;
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.5);
        }
        
        /* 토치 효과 */
        .torch {
            position: absolute;
            width: 12px;
            height: 12px;
            background: #ffc773;
            border-radius: 50%;
            box-shadow: 0 0 20px #ffc773, 0 0 40px #ffc773;
            animation: flicker 3s infinite alternate;
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
    </style>
    <script>
        function openTab(evt, tabName) {
            // 모든 탭 콘텐츠를 숨김
            var tabcontents = document.getElementsByClassName("tab-content");
            for (var i = 0; i < tabcontents.length; i++) {
                tabcontents[i].style.display = "none";
            }
            
            // 모든 탭 버튼에서 active 클래스 제거
            var tablinks = document.getElementsByClassName("tab-button");
            for (var i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            
            // 클릭된 탭 내용 표시하고 버튼에 active 클래스 추가
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        }
        
        // 페이지 로드 시 기본 탭 열기
        window.onload = function() {
            document.getElementById("defaultOpen").click();
        };
    </script>
</head>
<body>
<%ArrayList<GameWeb>list = (ArrayList<GameWeb>) request.getAttribute("list"); %>
<%ArrayList<GameWeb>strList = (ArrayList<GameWeb>) request.getAttribute("strList"); %>
<%ArrayList<GameWeb>dexList = (ArrayList<GameWeb>) request.getAttribute("dexList"); %>
<%ArrayList<GameWeb>intList = (ArrayList<GameWeb>) request.getAttribute("intList"); %>

    <div class="itemRecommendBody">
        <div class="torch torch-left"></div>
        <div class="torch torch-right"></div>
        
        <h1>모험가를 위한 직업별 추천 장비</h1>
        
        <div class="tab-container">
            <button class="tab-button" id="defaultOpen" onclick="openTab(event, 'allClasses')">모든 직업</button>
            <button class="tab-button" onclick="openTab(event, 'warrior')">전사</button>
            <button class="tab-button" onclick="openTab(event, 'rogue')">도적</button>
            <button class="tab-button" onclick="openTab(event, 'mage')">마법사</button>
        </div>
        
        <div id="allClasses" class="tab-content">
            <table>
                <tr>
                    <th>직업</th>
                    <th>추천 아이템</th>
                    <th>세트 효과</th>
                </tr>
                <% for(GameWeb game : list) { %>
                <tr>
                    <td><%=game.getCharacter_class() %></td>
                    <td><%=game.getArmour_set_name() %></td>
                    <td><%=game.getArmour_set_effect() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        
        <div id="warrior" class="tab-content">
            <div class="class-header">전사의 장비</div>
            <table>
                <tr>
                    <th>직업</th>
                    <th>추천 아이템</th>
                    <th>세트 효과</th>
                </tr>
                <% for(GameWeb game : strList) { %>
                <tr>
                    <td><%=game.getCharacter_class() %></td>
                    <td><%=game.getArmour_set_name() %></td>
                    <td><%=game.getArmour_set_effect() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        
        <div id="rogue" class="tab-content">
            <div class="class-header">도적의 장비</div>
            <table>
                <tr>
                    <th>직업</th>
                    <th>추천 아이템</th>
                    <th>세트 효과</th>
                </tr>
                <% for(GameWeb game : dexList) { %>
                <tr>
                    <td><%=game.getCharacter_class() %></td>
                    <td><%=game.getArmour_set_name() %></td>
                    <td><%=game.getArmour_set_effect() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        
        <div id="mage" class="tab-content">
            <div class="class-header">마법사의 장비</div>
            <table>
                <tr>
                    <th>직업</th>
                    <th>추천 아이템</th>
                    <th>세트 효과</th>
                </tr>
                <% for(GameWeb game : intList) { %>
                <tr>
                    <td><%=game.getCharacter_class() %></td>
                    <td><%=game.getArmour_set_name() %></td>
                    <td><%=game.getArmour_set_effect() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        
        <a href="/gameDBWeb/index" class="home-link">선술집으로 돌아가기</a>
    </div>
</body>
</html>