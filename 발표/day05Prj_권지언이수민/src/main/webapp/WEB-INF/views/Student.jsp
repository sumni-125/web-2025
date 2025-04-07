<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>학생 관리</title>
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
			<h2>학생 등록</h2>
			<form action="studentList" method="post">
				<label>학번</label> <input type="text" name="student_cd"> <label>아이디</label>
				<input type="text" name="id"> <label>비밀번호</label> <input
					type="text" name="pw"> <label>반 코드</label> <input
					type="text" name="class_cd"> <label>반 번호</label> <input
					type="text" name="class_no"> <label>학년</label> <input
					type="text" name="grade"> <label>이름</label> <input
					type="text" name="name"> <input type="submit" value="등록">
			</form>
		</div>

		<div class="right-box">
			<h2>학생 리스트</h2>
			<table>
				<thead>
					<tr>
						<th>학번</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>반 코드</th>
						<th>반 번호</th>
						<th>학년</th>
						<th>이름</th>
						<th>기능</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${list}">
						<tr>
							<td>${student.student_cd}</td>
							<td>${student.id}</td>
							<td>${student.pw}</td>
							<td>${student.class_cd}</td>
							<td>${student.class_no}</td>
							<td>${student.grade}</td>
							<td>${student.name}</td>
							<td><a href="updateForm?student_cd=${student.student_cd}"
								class="button-link">수정</a>
								<form action="studentList" method="post"
									style="display: inline;">
									<input type="hidden" name="action" value="delete"> <input
										type="hidden" name="student_cd" value="${student.student_cd}">
									<input type="submit" value="삭제" class="button-link">
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<a href="home" class="back-link">← 홈으로 돌아가기</a>
</body>
</html>
