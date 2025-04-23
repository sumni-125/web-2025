<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="tripMate.model.Cost"%>
<%@ page import="java.util.Arrays"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TripMate - 한번에결제</title>
<!-- 아이콘 폰트 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link href="css/costSplit.css" rel="stylesheet">
<style>

</style>
</head>
<body>
	<%
	// 서블릿에서 전달한 속성 꺼내기
	String sd_code = (String) request.getAttribute("sd_code"); // 여행 코드
	Cost pending = (Cost) request.getAttribute("pending"); // 분배 대상 Cost 객체
	String[] names = (String[]) request.getAttribute("names"); // 참여자 닉네임 배열
	%>

	<!-- 1) 상단 타이틀 -->
	<div class="top">
		<h1>
			<i class="fa-solid fa-receipt"></i> 한번에결제
		</h1>
	</div>

	<div class="wrapper">
		<!-- 2) 안내 문구 -->
		<div class="header-area">
			<h2>한번에 결제할 참여자를 선택하세요</h2>
		</div>

		<!-- 3) 본문 폼 -->
		<div class="content_wrap">
			<form action="<%=request.getContextPath()%>/costSplit" method="post">
				<!-- sd_code 유지 -->
				<input type="hidden" name="sd_code" value="<%=sd_code%>" />



				<!-- 5) 총 금액 표시 -->
				<div class="costItem_wrap">
					<div class="cost_item">
						<div class="text">
							<div>
								총 금액:
								<%=String.format("%,d원", pending.getAmount())%></div>
						</div>
					</div>
				</div>

				<!-- 6) 참여자별 금액 입력 -->
				<div class="costItem_wrap">
					<%
					// 카테고리별 아이콘 클래스 결정 (기존 로직 유지)
					String iconClass;
					switch (pending.getCategory()) {
					case "식사":
						iconClass = "fa-utensils";
						break;
					case "숙박":
						iconClass = "fa-bed";
						break;
					case "교통":
						iconClass = "fa-car";
						break;
					case "관광":
						iconClass = "fa-camera";
						break;
					case "쇼핑":
						iconClass = "fa-shopping-bag";
						break;
					case "항공":
						iconClass = "fa-plane";
						break;
					default:
						iconClass = "fa-ellipsis-h";
					}
					for (String name : names) {
					%>
					<div class="cost_item">

						<div class="text">
							<label>
								<div>
									<input type="checkbox" name="person" value="<%=name%>">
									<%=name%>님 지불 금액:
								</div>
							</label>
						</div>
						<!-- name 속성: 참여자 닉네임이 키가 되어 servlet에서 req.getParameter(nick)로 조회 -->
						<input type="number" name="<%=name%>" placeholder="0" min="0"
							required /> 원
					</div>
					<%
					}
					%>
				</div>

				<!-- 7) 이전 / 확인 버튼 -->
				<div class="bottom_button">
					<a class="back"
						href="<%=request.getContextPath()%>/costAdd?sd_code=<%=sd_code%>">이전</a>
					<button type="submit">확인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
