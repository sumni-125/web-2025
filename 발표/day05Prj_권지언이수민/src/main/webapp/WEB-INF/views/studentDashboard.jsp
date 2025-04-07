<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="teamproject.Student"%>
<%
Student student = (Student) session.getAttribute("student");
if (student == null) {
	response.sendRedirect("Login");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<title>학생 대시보드</title>
<link rel="stylesheet" href="style.css">
<style>
.dashboard {
	max-width: 600px;
	margin: 60px auto;
	padding: 30px;
	border: 1px solid #ccc;
	border-radius: 12px;
	background-color: #f9f9f9;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.dashboard h2 {
	margin-bottom: 10px;
}

.dashboard p {
	margin: 6px 0;
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="dashboard">
		<h2><%=student.getName()%>
			학생님 환영합니다!
		</h2>
		<p>
			<strong>학번:</strong>
			<%=student.getStudent_cd()%></p>
		<p>
			<strong>학년:</strong>
			<%=student.getGrade()%></p>
		<p>
			<strong>반:</strong>
			<%=student.getClass_no()%></p>
		<p>
			<strong>아이디:</strong>
			<%=student.getId()%></p>

		<a href="home" class="back-link">← 홈으로 돌아가기</a>
	</div>
</body>
</html>
