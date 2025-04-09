<%@page import="board.BoardPost"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<style>
    body {
        width: 700px;
        margin: 30px auto;
        background-color: #f9f9f9;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        border-radius: 8px;
    }

    h2 {
        border-bottom: 2px solid #ccc;
        padding-bottom: 5px;
        margin-top: 40px;
    }

    form {
        margin-bottom: 30px;
    }

    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 1em;
    }

    textarea {
        resize: none;
    }

    button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 18px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1em;
    }

    button:hover {
        background-color: #45a049;
    }

    .post {
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 5px;
        padding: 15px;
        margin-bottom: 15px;
    }

    .post p {
        margin: 5px 0;
    }

    .post_title {
        font-weight: bold;
        font-size: 1.1em;
    }

    .post_writer {
        color: #777;
        font-size: 0.9em;
    }

    .post_content {
        margin-top: 10px;
    }
</style>
</head>
<body>

<%
	String id = (String)request.getAttribute("id");
    ArrayList<BoardPost> posts = (ArrayList<BoardPost>)request.getAttribute("posts");
%>

<h2>게시판</h2>

<form action="/Board/boardmain" method="post">
    <input type="text" name="title" placeholder="글 제목" required><br>
    <textarea name="content" placeholder="내용을 작성해주세요." rows="5" cols="30" required></textarea><br>
    <button type="submit">글 작성</button>
</form>

<h2>글 목록</h2>

<%
for(int i = 0; i < posts.size(); i++) {
    BoardPost post = posts.get(i);
%>
    <div class="post">
    <p class="post_title">[<%= post.getPostId() %>] <%= post.getTitle() %></p>
    <p class="post_writer">👤 <%= (post.getWriter() != null ? post.getWriter() : "알 수 없음") %> | 🕒 <%= post.getWriteTime() %></p>
    <p class="post_content"><%= post.getContent().replaceAll("\n", "<br>") %></p>
    <form action="/Board/boardmain" method="post" style="display:inline;">
        <input type="hidden" name="deleteId" value="<%= post.getPostId() %>">
        <button type="submit">삭제</button>
    </form>
	</div>

<%
}
%>

</body>
</html>
