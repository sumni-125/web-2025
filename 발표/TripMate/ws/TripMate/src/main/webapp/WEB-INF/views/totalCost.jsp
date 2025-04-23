<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="tripMate.model.Cost, tripMate.model.PersonalCost, java.util.ArrayList"%>
<%
// sdCode 파라미터 받기
String sd_code = request.getParameter("sd_code");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 총 지출 내역</title>
<!-- 헤더 스타일 -->
<link href="css/header.css" rel="stylesheet">
<!-- Font Awesome 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/totalCost.css" rel="stylesheet">
<style>

</style>
</head>
<body>
	<header>
		<div class="logo">
			<a href="<%=request.getContextPath()%>/main?sd_code=<%=sd_code%>"><img
				class="logoImg" src="<%=request.getContextPath()%>/image/logo.png"
				alt=""></a>
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
					<h2><%=request.getAttribute("tripPeriod")%>
						<span>총 지출 내역</span><br><%=request.getAttribute("tripName")%></h2>
					<form method="get" action="<%=request.getContextPath()%>/totalCost">
						<input type="hidden" name="sd_code" value="<%=sd_code%>" /> <select
							name="filterName" class="person_select"
							onchange="this.form.submit()">
							<option value="">-- 사용자 선택 --</option>
							<%
							String[] names = (String[]) request.getAttribute("names");
							String filterName = (String) request.getAttribute("filterName");
							for (String n : names) {
							%>
							<option value="<%=n%>"
								<%=n.equals(filterName) ? "selected" : ""%>><%=n%></option>
							<%
							}
							%>
						</select>
					</form>
				</div>

				<%
				String[] categories = (String[]) request.getAttribute("categories");
				int filterIndex = (Integer) request.getAttribute("filterIndex");
				int[] sums = (int[]) request.getAttribute("sums");
				Cost[] costs = (Cost[]) request.getAttribute("costs");
				PersonalCost[] pcs = (PersonalCost[]) request.getAttribute("pcs");
				%>

				<%
				if (filterIndex < 0) {
				%>
				<p style="padding: 20px; color: #777;">사용자를 선택해주세요.</p>
				<%
				} else {
				for (int i = 0; i < categories.length; i++) {
					String cat = categories[i];
					int total = sums[i];
					String icon;
					switch (cat) {
					case "숙박":
						icon = "fa-bed";
						break;
					case "항공":
						icon = "fa-plane";
						break;
					case "교통":
						icon = "fa-bus";
						break;
					case "식사":
						icon = "fa-utensils";
						break;
					case "관광":
						icon = "fa-camera";
						break;
					case "쇼핑":
						icon = "fa-shopping-bag";
						break;
					default:
						icon = "fa-ellipsis";
					}
				%>
				<details>
					<summary>
						<div>
							<i class="fas <%=icon%>"></i><%=cat%></div>
						<div><%=String.format("%,d원", total)%></div>
					</summary>
					<div class="detail-list">
						<table>
							<tr>
								<th>날짜</th>
								<th>장소</th>
								<th>금액</th>
							</tr>
							<%
							String selCode = (String) request.getAttribute("filterUserCode");
							for (PersonalCost pc : pcs) {
								if (!pc.getUserCode().equals(selCode))
									continue;
								for (Cost c : costs) {
									if (!c.getCostId().equals(pc.getCostId()))
								continue;
									if (!c.getCategory().equals(cat))
								continue;
							%>
							<tr>
								<td><%=c.getTripDate()%></td>
								<td><%=c.getLocation()%></td>
								<td><%=String.format("%,d원", pc.getPersonCost())%></td>
							</tr>
							<%
							break;
							}
							}
							%>
						</table>
					</div>
				</details>
				<%
				} // end for categories
				int grandTotal = 0;
				for (int v : sums)
				grandTotal += v;
				%>
				<div class="grand-total">
					총 지출내역:
					<%=String.format("%,d원", grandTotal)%></div>
				<%
				} // end if
				%>
			</div>
		</div>
	</div>
</body>
</html>
