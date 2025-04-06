<%@page import="teamproject.Notice"%>
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
<% Notice notice =(Notice) request.getAttribute("notice"); %>


<div class="dashboard_wrap">
            <h2>알림장 수정</h2>

            <form action="/day05Prj/updateNotice" method="POST">
                <input type="hidden" name="class_cd" value="<%=notice.getClass_cd() %>">
                <input type="hidden" name="teacher_cd" value="<%=notice.getTeacher_cd() %>">
                <input type="hidden" name="notices_cd" value="<%=notice.getNotices_cd() %>">
                <input type="hidden" name="write_date" value="<%=notice.getWrite_date() %>">
                <label>제목:</label><br>
                <input name="title" type="text" value="<%=notice.getTitle()%>"><br><br>
                <label>내용:</label><br>
                <textarea cols="50" name="notices_description" value="<%=notice.getNotices_description() %>" rows="5"></textarea><br><br>
                <input class="submit_btn inputbox" type="submit" value="submit">
            </form>
            <a href = "/day05Prj/noticeList?teacher_cd=<%=notice.getTeacher_cd() %>">내가쓴 알림장 보기</a>
        </div>
</body>



</html>