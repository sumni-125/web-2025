<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모험가의 아이템 데이터베이스</title>    
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
        
        .header h1 {
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
        .header h1::after {
            content: '★';
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            color: #92734a;
            font-size: 24px;
        }
        
        .header h1::before {
            left: -40px;
        }
        
        .header h1::after {
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
        
        .welcome-banner {
            background-color: rgba(42, 26, 10, 0.8);
            border: 3px solid #3d2b17;
            border-radius: 5px;
            padding: 20px;
            text-align: center;
            margin-bottom: 40px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
        }
        
        .welcome-banner p {
            color: #d5b26b;
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 15px;
        }
        
        .navBar {
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
        }
        
        .navBar::before {
            content: '';
            position: absolute;
            top: 10px;
            left: 10px;
            right: 10px;
            bottom: 10px;
            border: 2px solid #92734a;
            pointer-events: none;
        }
        
        .navBar ul {
            list-style-type: none;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        
        .navBar li {
            position: relative;
            transition: transform 0.3s;
        }
        
        .navBar li:hover {
            transform: translateX(10px);
        }
        
        .navBar li::before {
            content: '➢';
            position: absolute;
            left: -20px;
            color: #92734a;
            opacity: 0;
            transition: opacity 0.3s, transform 0.3s;
        }
        
        .navBar li:hover::before {
            opacity: 1;
            transform: translateX(-5px);
        }
        
        .navBar a {
            display: block;
            padding: 15px 20px;
            background-color: rgba(58, 40, 23, 0.7);
            border: 2px solid #92734a;
            color: #e2c792;
            text-decoration: none;
            font-size: 18px;
            transition: all 0.3s;
            position: relative;
            overflow: hidden;
            text-align: center;
            letter-spacing: 1px;
        }
        
        .navBar a::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.1);
            transition: all 0.3s;
        }
        
        .navBar a:hover::before {
            left: 0;
        }
        
        .navBar a:hover {
            background-color: #4d3b27;
            color: #ffe6b3;
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.3);
        }
        
        /* 토치 효과 */
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
        
        .footer {
            text-align: center;
            margin-top: 40px;
            padding: 20px;
            color: #92734a;
            font-size: 14px;
            border-top: 1px solid rgba(146, 115, 74, 0.3);
        }
        
        /* 추가 장식 요소 */
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
        
        /* 반응형 디자인 */
        @media (min-width: 768px) {
            .navBar ul {
                flex-direction: row;
                flex-wrap: wrap;
                justify-content: center;
            }
            
            .navBar li {
                flex: 1 1 200px;
                max-width: 250px;
            }
        }
    </style>       
</head>
<body>
    <div class="tavern-container">
        <div class="decoration deco1">✦</div>
        <div class="decoration deco2">✧</div>
        <div class="decoration deco3">✦</div>
        <div class="decoration deco4">✧</div>
        
        <div class="header">
            <h1>아이템 데이터베이스</h1>            
        </div>
        
        <div class="welcome-banner">
            <p>모험가님, 선술집에 오신 것을 환영합니다!</p>
            <p>원하시는 정보를 찾아보세요. 당신의 모험에 도움이 될 것입니다.</p>
        </div>
        
        <div class="navBar">
            <div class="torch torch-left"></div>
            <div class="torch torch-right"></div>
            <ul>
                <li><a href="/gameDBWeb/index">선술집 홈</a></li>
                <li><a href="/gameDBWeb/itemcategory">아이템 목록</a></li>
                <li><a href="/gameDBWeb/gameRecommend">직업별 추천 아이템</a></li>
                <li><a href="/gameDBWeb/playerslist">모험가 명부</a></li>
                <li><a href="/gameDBWeb/gameLogin">선술집 나가기</a></li>
            </ul>
        </div>
        
        <div class="footer">
            <p>© 2025 모험가의 아이템 데이터베이스 | 모든 권리는 선술집 주인에게 있습니다.</p>
        </div>
    </div>
</body>
</html>