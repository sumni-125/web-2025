<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, tripMate.model.Cost"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 지출 내역</title>
<!-- 헤더 스타일 (변경) -->
<link href="<%=request.getContextPath()%>/css/header.css"
	rel="stylesheet">
<!-- 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/cost.css" rel="stylesheet">

<style>

</style>
</head>
<body>
	<%
	// 서블릿이 전달한 속성 꺼내기 (변경)
	String sd_code = (String) request.getAttribute("sd_code");
	String tripName = (String) request.getAttribute("tripName");
	String tripPeriod = (String) request.getAttribute("tripPeriod");
	String[] tripDates = (String[]) request.getAttribute("tripDates");
	// list는 ArrayList<Cost> 그대로 사용
	ArrayList<Cost> list = (ArrayList<Cost>) request.getAttribute("list");
	%>

	<header>
		<div class="logo">
			<!-- 로고 이미지 경로에 contextPath 적용 (변경) -->
			<a href="<%=request.getContextPath()%>/main?sd_code=<%=sd_code%>">
				<img class="logoImg"
				src="<%=request.getContextPath()%>/image/logo.png" alt="로고">
			</a>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/myTrip?sd_code=<%=sd_code%>">여행일정</a>
		</div>
		<div>
			<a href="">관광지</a>
		</div>
		<div>
			<a href="">블로그</a>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/myPage?sd_code=<%=sd_code%>">마이페이지</a>
		</div>
	</header>

	<div class="top">
		<h1>
			<i class="fa-solid fa-calculator"></i> 여행비 가계부
		</h1>
		<div class="button">
			<button class="button1"
				onclick="location.href='<%=request.getContextPath()%>/cost?sd_code=<%=sd_code%>'">지출
				내역</button>
			<button class="button2"
				onclick="location.href='<%=request.getContextPath()%>/personalCost?sd_code=<%=sd_code%>'">개인
				정산 내역</button>
			<button class="button3"
				onclick="location.href='<%=request.getContextPath()%>/totalCost?sd_code=<%=sd_code%>'">총
				지출 내역</button>
		</div>
	</div>

	<div class="bottom">
		<div class="content_wrap">
			<div class="content">
				<div class="content_title">
					<h2>
						<%=tripPeriod%>
						<span>여행 지출 내역</span><br>
						<%=tripName%>
					</h2>

					<!-- 날짜 선택 바 -->
					<select id="daySelect" class="day_select">
						<option value="" disabled hidden>날짜를 선택하세요</option>
						<%
						for (String d : tripDates) {
						%>
						<option value="<%=d%>"><%=d%></option>
						<%
						}
						%>
					</select>

					<!-- 소비기록 추가 버튼 -->
					<button class="button4"
						onclick="location.href='<%=request.getContextPath()%>/costAdd?sd_code=<%=sd_code%>'">소비기록
						추가</button>
				</div>

				<!-- 일별 지출 내역 -->
				<div class="day_container">
					<%
					for (int i = 0; i < tripDates.length; i++) {
						String date = tripDates[i];
					%>
					<div class="day" data-date="<%=date%>">
						<p>
							Day<%=i + 1%>
							|
							<%=date%></p>
						<%
						for (Cost c : list) {
							if (!c.getTripDate().equals(date))
								continue;
							String ic;
							switch (c.getCategory()) {
								case "식사" :
							ic = "fa-utensils";
							break;
								case "관광" :
							ic = "fa-landmark";
							break;
								case "교통" :
							ic = "fa-car";
							break;
								case "숙박" :
							ic = "fa-bed";
							break;
								case "항공" :
							ic = "fa-plane";
							break;
								case "쇼핑" :
							ic = "fa-shopping-bag";
							break;
								default :
							ic = "fa-ellipsis-h";
							}
						%>
						<div class="cost_item">
							<div class="left">
								<i class="fas <%=ic%>"></i>
								<div>
									<div class="category"><%=c.getCategory()%>비
									</div>
									<div class="location"><%=c.getLocation()%></div>
								</div>
							</div>
							<div class="right">
								<div class="amount"><%=String.format("%,d원", c.getAmount())%></div>
								<div class="method">
									(<%=c.getPaymentMethod()%>)
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>

	<script>
    const select = document.getElementById('daySelect');
    const days   = document.querySelectorAll('.day');
    // 페이지 로드 시 첫 번째 날짜 자동 선택 (추가)
    window.addEventListener('DOMContentLoaded', () => {
        if (select.options.length > 1) {
            select.selectedIndex = 1;              // 첫 번째 날짜 옵션 선택
            select.dispatchEvent(new Event('change'));
        }
    });
    select.addEventListener('change', () => {
        const v = select.value;
        days.forEach(d => d.style.display = (d.dataset.date === v) ? 'block' : 'none');
    });
</script>
</body>
</html>
