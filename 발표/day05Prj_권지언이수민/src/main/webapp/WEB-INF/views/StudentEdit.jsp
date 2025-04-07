<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>학생 정보 수정</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<style>
.back-link {
	display: block;
	width: fit-content;
	margin: 30px auto 0;
	color: #555;
	text-decoration: none;
	font-size: 14px;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-radius: 6px;
	background-color: #f2f2f2;
	transition: background-color 0.2s ease;
}

.back-link:hover {
	background-color: #e0e0e0;
	text-decoration: underline;
}
</style>
<body>

	<div class="layout">
		<div class="left-box">
			<h2>학생 정보 수정</h2>

			<form action="updateStudent" method="post">

				<input type="hidden" name="old_cd" value="${s.student_cd}">

				<label>학번</label> <input type="text" name="student_cd"
					value="${s.student_cd}"> <label>아이디</label> <input
					type="text" name="id" value="${s.id}"> <label>비밀번호</label>
				<input type="text" name="pw" value="${s.pw}"> <label>반
					코드</label> <input type="text" name="class_cd" value="${s.class_cd}">

				<label>반 번호</label> <input type="text" name="class_no"
					value="${s.class_no}"> <label>학년</label> <input type="text"
					name="grade" value="${s.grade}"> <label>이름</label> <input
					type="text" name="name" value="${s.name}"> <input
					type="submit" value="수정 완료">
			</form>
		</div>
	</div>
	<a href="home" class="back-link">← 홈으로 돌아가기</a>
</body>
</html>
