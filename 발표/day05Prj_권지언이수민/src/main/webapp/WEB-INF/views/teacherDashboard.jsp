<%@page import="teamproject.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Teacher teacher =(Teacher) session.getAttribute("teacher"); %>


<div class="dashboard_wrap">
            <h2>📚 Write Notice (Administrator🧑‍💼)</h2>

            <form action="/day05Prj/insertNotice" method="POST">
                <input type="hidden" name="class_cd" value="<%=teacher.getClass_cd() %>">
                <input type="hidden" name="teacher_cd" value="<%=teacher.getTeacher_cd() %>">
                
                <label>제목:</label><br>
                <input name="title" required="" type="text"><br><br>
                <label>내용:</label><br>
                <textarea cols="50" name="notices_description" required="" rows="5"></textarea><br><br>
                <input class="submit_btn inputbox" type="submit" value="submit">
            </form>
            <a href = "/day05Prj/noticeList?teacher_cd=<%=teacher.getTeacher_cd() %>">내가쓴 알림장 보기</a>
        </div>
</body>



</html>