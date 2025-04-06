<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>학부모 관리</title>
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
			<h2>학부모 등록</h2>
			<form action="parentsList" method="post">
				<label>학부모 코드</label> <input type="text" name="parent_id"> <label>자녀
					코드</label> <input type="text" name="student_cd"> <label>아이디</label>
				<input type="text" name="id"> <label>비밀번호</label> <input
					type="text" name="pw"> <label>전화번호</label> <input
					type="text" name="tel"> <input type="submit" value="등록">
			</form>
		</div>

		<div class="right-box">
			<h2>학부모 리스트</h2>
			<table>
				<thead>
					<tr>
						<th>학부모 코드</th>
						<th>자녀 코드</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>전화번호</th>
						<th>기능</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="parents" items="${list}">
						<tr>
							<td>${parents.parent_id}</td>
							<td>${parents.student_cd}</td>
							<td>${parents.id}</td>
							<td>${parents.pw}</td>
							<td>${parents.tel}</td>
							<td><a href="updateForm?parent_id=${parents.parent_id}"
								class="button-link">수정</a>
								<form action="parentsList" method="post"
									style="display: inline;">
									<input type="hidden" name="action" value="delete"> <input
										type="hidden" name="parent_id" value="${parents.parent_id}">
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
