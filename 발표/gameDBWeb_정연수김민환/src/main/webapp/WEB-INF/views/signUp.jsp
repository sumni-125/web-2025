<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모험가 등록</title>
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
            overflow: hidden;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            padding: 20px 0;
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
        
        .logo {
            margin: 20px 0;
            position: relative;
            z-index: 1;
        }
        
        .logo-image {
            max-width: 120px;
            filter: sepia(50%) brightness(90%);
            border: 3px solid #92734a;
            border-radius: 50%;
            padding: 5px;
            background-color: rgba(42, 26, 10, 0.7);
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.3);
        }
        
        .header {
            margin-bottom: 20px;
            text-align: center;
        }
        
        .header h1 {
            color: #e2c792;
            font-size: 28px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
            letter-spacing: 3px;
            font-variant: small-caps;
            position: relative;
            display: inline-block;
        }
        
        .header h1::before, .header h1::after {
            content: '❖';
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            color: #92734a;
            font-size: 20px;
        }
        
        .header h1::before {
            left: -40px;
        }
        
        .header h1::after {
            right: -40px;
        }
        
        .signUpBody {
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
            margin-bottom: 30px;
        }
        
        .signUpBody::before {
            content: '';
            position: absolute;
            top: 10px;
            left: 10px;
            right: 10px;
            bottom: 10px;
            border: 2px solid #92734a;
            pointer-events: none;
        }
        
        .signUpBody h1 {
            color: #e2c792;
            margin-bottom: 30px;
            font-size: 32px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            font-weight: normal;
            letter-spacing: 2px;
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
        
        /* 장식 요소들 */
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
        
        /* 양피지 질감 */
        .parchment-border {
            position: absolute;
            top: -10px;
            left: -10px;
            right: -10px;
            bottom: -10px;
            border: 2px solid rgba(146, 115, 74, 0.3);
            pointer-events: none;
            z-index: -1;
        }
    </style>
</head>
<body>
    <div class="logo">
        <img src="image/logo.png" alt="로고" class="logo-image">
    </div>
    <div class="header">
        <h1>Acorn chronicle</h1>
    </div>

    <div class="signUpBody">
        <div class="torch torch-left"></div>
        <div class="torch torch-right"></div>
        <div class="parchment-border"></div>
        <h1>모험가 등록</h1>
        <form action="/gameDBWeb/gameSignUp" method="POST">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="account_id" placeholder="사용할 아이디를 입력하세요">
            
            <label for="password">암호:</label>
            <input type="password" id="password" name="account_pw" placeholder="안전한 비밀번호를 입력하세요">
            
            <label for="name">모험가 이름:</label>
            <input type="text" id="name" name="account_name" placeholder="당신의 이름을 알려주세요">
            
            <input type="submit" value="모험 시작하기">
        </form>
        <p>
            이미 등록된 모험가이신가요? <a href="/gameDBWeb/gameLogin">선술집 입장하기</a>
        </p>
    </div>
</body>
</html>