<%@page import="java.util.ArrayList"%>
<%@page import="movie.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movie List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        .movie-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .movie-item:last-child {
            border-bottom: none;
        }
        .movie-poster img {
            max-width: 100px;
            border-radius: 4px;
            margin-right: 15px;
        }
        .movie-details {
            display: inline-block;
          
        }
        .movie-details p {
            margin: 5px 0;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Movie List</h1>
    
 
   
        // 영화 리스트 출력
      
        <div class="movie-item">
            <div class="movie-poster">
                <img src=" " alt=""  >
            </div>
            <div class="movie-details">
                <h2> </h2>               
                <p><strong>Genre:</strong>  </p>
                <p><strong>Description:</strong> </p>
            </div>
        </div>
     
    
</div>

</body>
</html>
