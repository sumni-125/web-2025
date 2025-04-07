<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="game_item.ItemCategory" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모험가의 아이템 카테고리</title>
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
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 40px 20px;
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
        
        .item-container {
            background-color: #2a1a0a;
            border: 8px solid #3d2b17;
            border-radius: 5px;
            box-shadow: 0 0 20px rgba(255, 200, 100, 0.3),
                        inset 0 0 30px rgba(0, 0, 0, 0.5);
            padding: 40px;
            width: 100%;
            max-width: 800px;
            position: relative;
            background-image: url('https://cdnjs.cloudflare.com/ajax/libs/simple-icons/3.0.1/ghost.svg');
            background-blend-mode: overlay;
            background-size: cover;
        }
        
        .item-container::before {
            content: '';
            position: absolute;
            top: 10px;
            left: 10px;
            right: 10px;
            bottom: 10px;
            border: 2px solid #92734a;
            pointer-events: none;
        }
        
        h2 {
            color: #e2c792;
            text-align: center;
            margin-bottom: 30px;
            font-size: 32px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            font-weight: normal;
            letter-spacing: 2px;
            position: relative;
            padding-bottom: 15px;
        }
        
        h2::after {
            content: "";
            position: absolute;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 200px;
            height: 2px;
            background: linear-gradient(to right, transparent, #92734a, transparent);
        }
        
        .category-list {
            list-style-type: none;
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }
        
        .category-item {
            text-align: center;
            transition: transform 0.3s;
        }
        
        .category-item:hover {
            transform: translateY(-5px);
        }
        
        .category-button {
            width: 100%;
            background-color: #3d2b17;
            color: #e2c792;
            border: 2px solid #92734a;
            padding: 15px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s;
            font-family: 'Times New Roman', serif;
            text-transform: capitalize;
            position: relative;
            overflow: hidden;
        }
        
        .category-button::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.1);
            transition: all 0.3s;
        }
        
        .category-button:hover::before {
            left: 0;
        }
        
        .category-button:hover {
            background-color: #5c3f1d;
            color: #ffe6b3;
            box-shadow: 0 0 15px rgba(255, 200, 100, 0.3);
        }
        
        .empty-message {
            text-align: center;
            color: #b29f7c;
            font-style: italic;
            margin: 30px 0;
        }
        
        .home-link {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 25px;
            background-color: #5c3f1d;
            color: #e2c792;
            text-decoration: none;
            border: 2px solid #92734a;
            text-align: center;
            font-size: 16px;
            transition: all 0.3s;
            align-self: center;
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
</head>
<body>
    <div class="item-container">
        <div class="torch torch-left"></div>
        <div class="torch torch-right"></div>
        
        <h2>모험가의 장비 보관함</h2>
        
        <ul class="category-list">
            <%
                ArrayList<ItemCategory> categories = (ArrayList<ItemCategory>) request.getAttribute("categoryList");
                if (categories != null && !categories.isEmpty()) {
                    for (ItemCategory category : categories) {
            %>
                <li class="category-item">
                    <form action="ItemListServlet" method="get">
                        <input type="hidden" name="categoryId" value="<%= category.getCategoryId() %>"/>
                        <input type="submit" value="<%= category.getCategoryName() %>" class="category-button"/>
                    </form>
                </li>
            <%
                    }
                } else {
            %>
                <li class="empty-message">보관함이 비어있습니다. 모험에서 돌아오면 아이템을 찾아보세요.</li>
            <%
                }
            %>
        </ul>
        
        <a href="/gameDBWeb/index" class="home-link">선술집으로 돌아가기</a>
    </div>
</body>
</html>