<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="tripMate.model.PersonalCost"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 개인 정산 내역</title>
<!-- 헤더 스타일 -->
<link href="<%=request.getContextPath()%>/css/header.css"
	rel="stylesheet">
<!-- Font Awesome 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/personalCost.css" rel="stylesheet">
<style>

</style>
</head>
<body>
	<%
	// 바디 안쪽에서만 꺼내기
	String sd_code = (String) request.getAttribute("sd_code"); // 여행 코드
	String tripName = (String) request.getAttribute("tripName"); // 여행 제목
	String tripPeriod = (String) request.getAttribute("tripPeriod"); // 여행 기간
	String selectedIndex = request.getParameter("personIndex"); // 선택된 사람 인덱스
	String[] nameList = (String[]) request.getAttribute("nameList"); // 사람 닉네임 배열
	PersonalCost[][] pendingGiveList = (PersonalCost[][]) request.getAttribute("pendingGiveList"); // 대기 내역 배열
	PersonalCost[][] completedGiveList = (PersonalCost[][]) request.getAttribute("completedGiveList"); // 완료 내역 배열
	%>

	<header>
		<div class="logo">
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

	<!-- 상단 타이틀 및 네비게이션 -->
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

	<!-- 본문 -->
	<div class="bottom">
		<div class="content_wrap">
			<div class="content">

				<!-- 제목 및 사람 선택 -->
				<div class="content_title">
					<h2>
						<%=tripPeriod%>
						<span>여행 정산 내역</span><br>
						<%=tripName%>
					</h2>
					<select id="personSelect" class="person_select">
						<option value="" disabled hidden>정산 내역을 볼 사람 선택</option>
						<%
						for (int i = 0; i < nameList.length; i++) {
							String sel = String.valueOf(i).equals(selectedIndex) ? "selected" : "";
						%>
						<option value="<%=i%>" <%=sel%>><%=nameList[i]%> 님
						</option>
						<%
						}
						%>
					</select>
				</div>

				<!-- 정산 내역 표시 -->
				<div class="day_container">
					<%
					for (int i = 0; i < nameList.length; i++) {
					%>
					<div class="day" data-person="<%=i%>">
						<!-- 대기중 내역 -->
						<div class="personal_wrap">
							<div class="section-header1">정산 대기중</div>
							<%
							PersonalCost[] pendings = pendingGiveList[i];
							int visiblePendingCount = 0;
							for (PersonalCost pc : pendings) {
								if (!pc.getUserCode().equals(pc.getPayer())) {
									visiblePendingCount++;
								}
							}
							if (visiblePendingCount == 0) {
							%>
							<div class="empty-text">내역이 없습니다.</div>
							<%
							} else {
							for (PersonalCost pc : pendings) {
								if (pc.getUserCode().equals(pc.getPayerCode()))
								    continue;
							%>
							<div class="give-item">
								<div class="info">
									<i class="fa-solid fa-user"></i>
									<div class="p">
										<strong><%=pc.getPayer()%></strong>님께
									</div>
								</div>
								<div class="amount">
									<%=String.format("%,d원", pc.getPersonCost())%>
									<form action="<%=request.getContextPath()%>/personalCost"
										method="post" style="display: inline-block; margin-left: 8px;">
										<input type="hidden" name="personalCostId"
											value="<%=pc.getPersonalCostId()%>" /> <input type="hidden"
											name="personIndex" value="<%=i%>" /> <input type="hidden"
											name="sd_code" value="<%=sd_code%>">
										<button type="submit" class="complete-btn">정산완료</button>
									</form>
								</div>
							</div>
							<%
							}
							}
							%>
						</div>

						<!-- 완료된 내역 -->
						<div class="personal_wrap">
							<div class="section-header2">완료된 내역</div>
							<%
							PersonalCost[] completes = completedGiveList[i];
							int visibleCompleteCount = 0;
							for (PersonalCost pc : completes) {
								if (!pc.getUserCode().equals(pc.getPayerCode())) {
									visibleCompleteCount++;
								}
							}
							if (visibleCompleteCount == 0) {
							%>
							<div class="empty-text">내역이 없습니다.</div>
							<%
							} else {
							for (PersonalCost pc : completes) {
								if (pc.getUserCode().equals(pc.getPayerCode()))
								    continue;
							%>
							<div class="give-item completed">
								<div class="info">
									<i class="fa-solid fa-user"></i>
									<div class="p">
										<strong><%=pc.getPayer()%></strong>님께
									</div>
								</div>
								<div class="amount"><%=String.format("%,d원", pc.getPersonCost())%></div>
							</div>
							<%
							}
							}
							%>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>

	<script>
    const select = document.getElementById('personSelect');
    const days   = document.querySelectorAll('.day');
    // 페이지 로드 시 기본 선택
    window.addEventListener('DOMContentLoaded', () => {
        if (!select.value && select.options.length > 1) {
            select.selectedIndex = 1;
        }
        select.dispatchEvent(new Event('change'));
    });
    // 선택된 사람 인덱스에 따라 해당 div 표시
    select.addEventListener('change', () => {
        days.forEach(d => {
            d.style.display = (d.dataset.person === select.value) ? 'flex' : 'none';
        });
    });
</script>
</body>
</html>
