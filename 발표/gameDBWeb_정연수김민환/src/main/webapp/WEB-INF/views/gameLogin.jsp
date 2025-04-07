<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판타지 게임 로그인</title>
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
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #d9c08c;
            position: relative;
            overflow: hidden;
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
        
        .loginBody {
            background-color: #2a1a0a;
            border: 8px solid #3d2b17;
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(255, 200, 100, 0.3),
                        inset 0 0 30px rgba(0, 0, 0, 0.5);
            padding: 40px;
            width: 400px;
            text-align: center;
            position: relative;
            background-image: url('https://cdnjs.cloudflare.com/ajax/libs/simple-icons/3.0.1/ghost.svg');
            background-blend-mode: overlay;
            background-size: cover;
            opacity: 0.9;
        }
        
        .loginBody::before {
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
            margin-bottom: 30px;
            font-size: 32px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            font-weight: normal;
            letter-spacing: 2px;
            font-family: 'Times New Roman', serif;
        }
        
        label {
            display: block;
            text-align: left;
            margin-bottom: 8px;
            color: #d5b26b;
            font-size: 16px;
            text-shadow: 0 1px 2px rgba(0, 0, 0, 0.8);
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            background-color: rgba(43, 27, 14, 0.7);
            border: 2px solid #92734a;
            border-radius: 0;
            font-size: 16px;
            color: #e2c792;
            font-family: 'Times New Roman', serif;
        }
        
        input[type="text"]::placeholder,
        input[type="password"]::placeholder {
            color: #a89173;
        }
        
        input[type="submit"] {
            width: 80%;
            background-color: #5c3f1d;
            color: #e2c792;
            border: 2px solid #92734a;
            border-radius: 0;
            padding: 12px;
            font-size: 18px;
            cursor: pointer;
            margin: 10px auto 20px;
            text-transform: uppercase;
            letter-spacing: 2px;
            font-weight: bold;
            text-shadow: 0 1px 2px rgba(0, 0, 0, 0.8);
            transition: all 0.3s ease;
            font-family: 'Times New Roman', serif;
        }
        
        input[type="submit"]:hover {
            background-color: #7c5734;
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.5);
        }
        
        p {
            color: #b29f7c;
            font-size: 16px;
            margin-top: 15px;
        }
        
        a {
            color: #e2c792;
            text-decoration: none;
            font-weight: bold;
            transition: all 0.3s;
        }
        
        a:hover {
            color: #ffdb9e;
            text-shadow: 0 0 8px rgba(255, 200, 100, 0.8);
        }
        
        /* 촛불 효과 */
        .candle {
            position: absolute;
            width: 10px;
            height: 10px;
            background: #ffc773;
            border-radius: 50%;
            box-shadow: 0 0 15px #ffc773, 0 0 30px #ffc773;
            animation: flicker 2s infinite alternate;
        }
        
        .candle-left {
            top: 30px;
            left: 30px;
        }
        
        .candle-right {
            top: 30px;
            right: 30px;
        }
        
        @keyframes flicker {
            0%, 100% {
                opacity: 1;
                box-shadow: 0 0 15px #ffc773, 0 0 30px #ffc773;
            }
            50% {
                opacity: 0.8;
                box-shadow: 0 0 10px #ffc773, 0 0 20px #ffc773;
            }
        }
        
        
    </style>
</head>
<body>
    <div class="loginBody">
        <div class="candle candle-left"></div>
        <div class="candle candle-right"></div>
        <img src="image/logo.png" alt="로고" style="width: 100px; margin-bottom: 20px;">
        <h1>Acorn Chronicle</h1>
        <form action="/gameDBWeb/gameLogin" method="POST">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="id" placeholder="당신의 이름을 알려주세요...">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="pw" placeholder="암호를 말하세요...">
            <input type="submit" value="입장하기">
        </form> 
        <p>회원이 아니신가요? <a href="/gameDBWeb/gameSignUp">회원가입</a></p>
    </div>
</body>
</html>