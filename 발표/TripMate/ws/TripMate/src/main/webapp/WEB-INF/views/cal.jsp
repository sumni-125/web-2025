<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js"></script>
<link href="css/cal.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
</head>

<body>
<header>
	<div class="logo">
		<a href="<%=request.getContextPath()%>/main"><img class="logoImg" src="image/logo.png"
			alt=""></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myTrip">여행일정</a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainsearch">관광지</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/mainblog">블로그</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/myPage">마이페이지</a>

	</div>
</header>
	<div class="container">
		<div id="calendar-container">
			<div id="calendar"></div>
		</div>

		<div id="info-panel">
			<h2>선택한 기간</h2>
			<div id="selected-dates">선택한 날짜 없음</div>

			<form id="date-form" method="post" action="<%=request.getContextPath()%>/tripCal">
				<input type="hidden" name="startDate" id="startDate">
				<input type="hidden" name="endDate" id="endDate">
				<button type="submit" id="next-button">다음</button>
			</form>
		</div>
	</div>

	<script>
		(function() {
			$(function() {
				var calendarEl = $('#calendar')[0];
				var firstClick = null;
				var highlightEvent = null;
				let selectedStart = null;
				let selectedEnd = null;

				var calendar = new FullCalendar.Calendar(calendarEl, {
					height: '100%',
					expandRows: true,
					headerToolbar: {
						left: 'prev,next today',
						center: 'title',
						right: ''
					},
					initialView: 'dayGridMonth',
					initialDate: new Date(),
					navLinks: false,
					editable: false,
					selectable: false,
					nowIndicator: true,
					dayMaxEvents: true,
					locale: 'ko',

					events: [
						{
							title: '제주도 여행',
							start: '2025-04-05',
							end: '2025-04-07',
							color: '#607D8B'
						},
						{
							title: '우도 여행',
							start: '2025-04-06',
							end: '2025-04-11',
							color: '#607D8B'
						}
					],

					dateClick: function(info) {
						if (highlightEvent) {
							highlightEvent.remove();
							highlightEvent = null;
						}

						if (!firstClick) {
							firstClick = info.dateStr;
							$('#selected-dates').html("시작 날짜: " + firstClick + "<br>종료 날짜를 선택하세요.");
							selectedStart = firstClick;
							selectedEnd = null;
						} else {
							let start = new Date(firstClick);
							let end = new Date(info.dateStr);

							if (start > end) {
								[ start, end ] = [ end, start ];
							}

							const startStr = start.toISOString().split('T')[0];
							const endStr = end.toISOString().split('T')[0];
							const diffTime = Math.abs(end - start);
							const diffDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1;

							let endDate = new Date(end);
							endDate.setDate(endDate.getDate() + 1);
							const endStrPlus = endDate.toISOString().split('T')[0];

							$('#selected-dates').html(
								"선택한 기간:<br>" + startStr + " ~ " + endStr +
								"<br><br>총 <strong>" + diffDays + "</strong>일"
							);

							highlightEvent = calendar.addEvent({
								start: startStr,
								end: endStrPlus,
								display: 'background',
								backgroundColor: '#FFEB3B'
							});

							selectedStart = startStr;
							selectedEnd = endStr;
							firstClick = null;
						}
					}
				});

				calendar.render();

				$('#next-button').on('click', function(e) {
					if (selectedStart && selectedEnd) {
						$('#startDate').val(selectedStart);
						$('#endDate').val(selectedEnd);
					} else {
						e.preventDefault(); // 제출 막기
						alert('날짜를 먼저 선택해 주세요.');
					}
				});
			});
		})();
	</script>
</body>

</html>
