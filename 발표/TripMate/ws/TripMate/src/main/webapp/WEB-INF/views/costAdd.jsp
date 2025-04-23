<%@ page import="java.util.ArrayList, tripMate.model.Cost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 소비 기록 추가</title>
<!-- Font Awesome 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/costAdd.css" rel="stylesheet">
<style>
</style>
</head>
<body>

	<!-- 상단 제목 -->
	<div class="top">
		<h1>
			<i class="fa-solid fa-receipt"></i> 소비기록 추가
		</h1>
	</div>

	<!-- 내용 입력 -->
	<div class="bottom">
		<div class="content_wrap">
			<div class="content">

				<%
				// 서블릿이 전달한 파라미터 및 속성 꺼내기
				String sd_code = request.getParameter("sd_code"); // URL 파라미터로 받은 sd_code
				String tripName = (String) request.getAttribute("tripName"); // 여행 제목
				String tripPeriod = (String) request.getAttribute("tripPeriod"); // 여행 기간
				String[] tripDates = (String[]) request.getAttribute("tripDates"); // 여행 날짜 배열
				ArrayList<String> cats = (ArrayList<String>) request.getAttribute("category"); // 카테고리 목록
				ArrayList<String> types = (ArrayList<String>) request.getAttribute("paymentType"); // 결제수단 목록
				ArrayList<String> methods = (ArrayList<String>) request.getAttribute("paymentMethod"); // 결제방식 목록
				ArrayList<String> names = (ArrayList<String>) request.getAttribute("names"); // 참여자(결제자) 목록
				%>

				<!-- 여행지 정보 및 부제목 -->
				<h3>
					<%=tripPeriod%>
					<span class="subtitle">여행 지출 내역 추가</span><br>
					<%=tripName%>
				</h3>

				<!-- /costAdd 서블릿으로 전송 -->
				<form
					action="<%=request.getContextPath()%>/costAdd?sd_code=<%=sd_code%>"
					method="post">
					<!-- hidden 필드로 sd_code 유지 -->
					<input type="hidden" name="sd_code" value="<%=sd_code%>" />

					<!-- 날짜 -->
					<label> <span>날짜</span> <select name="tripDate" required>
							<option value="" disabled selected hidden>날짜 선택</option>
							<%
							for (String d : tripDates) {
							%>
							<option value="<%=d%>"><%=d%></option>
							<%
							}
							%>
					</select>
					</label>

					<!-- 결제 수단 -->
					<label> <span>결제 수단</span> <select name="paymentType"
						required>
							<option value="" disabled selected hidden>결제 수단 선택</option>
							<%
							for (String t : types) {
							%>
							<option value="<%=t%>"><%=t%></option>
							<%
							}
							%>
					</select>
					</label>

					<!-- 장소 -->
					<label> <span>장소</span> <input type="text" name="location"
						placeholder="장소 입력" required>
					</label>

					<!-- 카테고리 -->
					<span>카테고리</span>
					<div class="category">
						<%
						for (String cat : cats) {
							String iconClass;
							switch (cat) {
							case "숙박":
								iconClass = "fa-bed";
								break;
							case "항공":
								iconClass = "fa-plane";
								break;
							case "교통":
								iconClass = "fa-car";
								break;
							case "식사":
								iconClass = "fa-utensils";
								break;
							case "관광":
								iconClass = "fa-camera";
								break;
							case "쇼핑":
								iconClass = "fa-shopping-bag";
								break;
							default:
								iconClass = "fa-ellipsis-h";
							}
						%>
						<label> <input type="radio" name="category"
							value="<%=cat%>" required> <i class="fas <%=iconClass%>"></i><%=cat%>
						</label>
						<%
						}
						%>
					</div>

					<!-- 결제 금액 -->
					<label> <span>결제 금액</span> <input type="number"
						name="amount" placeholder="결제 금액 입력" required>
					</label>

					<!-- 결제 방식 -->
					<label> <span>결제 방식</span> <select name="paymentMethod"
						required>
							<option value="" disabled selected hidden>방식 선택</option>
							<%
							for (String m : methods) {
							%>
							<option value="<%=m%>"><%=m%></option>
							<%
							}
							%>
					</select>
					</label>

					<!-- 결제자 -->
					<label> <span>결제자</span> <select name="payer" required>
							<option value="" disabled selected hidden>결제자 선택</option>
							<%
							for (String n : names) {
							%>
							<option value="<%=n%>"><%=n%></option>
							<%
							}
							%>
					</select>
					</label>

					<!-- 이전, 등록버튼 -->
					<div class="bottom_button">
						<a class="back"
							href="<%=request.getContextPath()%>/cost?sd_code=<%=sd_code%>">이전</a>
						<button type="submit" class="commit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
