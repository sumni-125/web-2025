<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, tripMate.model.Cost"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 1/N 정산</title>
<!-- 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/costDivide.css" rel="stylesheet">
<style>
</style>
</head>
<body>
	<%
	// 서블릿에서 전달한 속성 및 파라미터 꺼내기
	String sdCode = (String) request.getAttribute("sd_code"); // 여행코드
	Cost pending = (Cost) request.getAttribute("pending"); // 분배 대상 비용 객체
	ArrayList<String> names = (ArrayList<String>) request.getAttribute("names"); // 참여자 닉네임 목록
	String error = (String) request.getAttribute("error"); // 에러 메시지(있다면)
	%>

	<!-- 1) 상단 타이틀 -->
	<div class="top">
		<h1>
			<i class="fa-solid fa-receipt"></i> 1/N 정산
		</h1>
	</div>

	<div class="wrapper">
		<!-- 2) 안내 문구 -->
		<div class="header-area">
			<h2>할당할 참여자를 선택하세요</h2>
		</div>

		<!-- 에러 메시지 출력 -->
		<%
		if (error != null) {
		%>
		<div class="error"><%=error%></div>
		<%
		}
		%>

		<!-- 3) 본문 폼 -->
		<div class="content_wrap">
			<form action="<%=request.getContextPath()%>/costDivide" method="post">
				<!-- hidden 필드로 sd_code 유지 -->
				<input type="hidden" name="sd_code" value="<%=sdCode%>" />

				<!-- 4) 총 금액 표시 -->
				<div class="costItem_wrap">
					<div class="cost_item">
						<div class="text">
							<div>
								총 금액:
								<%=pending.getAmount()%>원
							</div>
						</div>
					</div>
				</div>

				<!-- 5) 참여자 체크박스 -->
				<div class="person-list">
					<%
					for (String name : names) {
					%>
					<label> <input type="checkbox" name="person"
						value="<%=name%>"> <%=name%>
					</label>
					<%
					}
					%>
				</div>

				<!-- 6) 이전 / 확인 버튼 -->
				<div class="bottom_button">
					<a class="back"
						href="<%=request.getContextPath()%>/costAdd?sd_code=<%=sdCode%>">이전</a>
					<button type="submit">확인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
