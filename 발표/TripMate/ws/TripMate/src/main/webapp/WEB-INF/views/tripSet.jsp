<%@page import="java.util.ArrayList"%>
<%@page import="tripMate.model.MarkerData"%>
<%@page import="tripMate.model.Schedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>여행 일정 확인</title>
<link href="css/header.css" rel="stylesheet">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap')
	;

* {
	font-family: "Noto Sans KR", serif;
	font-optical-sizing: auto;
	font-weight: 400;
	font-style: normal;
}

/* 스타일은 그대로 */
body {
	margin: 0;
	font-family: sans-serif;
	min-width: 1000px;
	background-color: #f9fafb;
}

.map_wrap {
	display: flex;
	flex-direction: row;
	gap: 20px;
	padding: 20px;
}

#map {
	width: 70%;
	height: 680px;
	border-radius: 10px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}

.sidebar {
	width: 25%;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	padding: 20px 30px;
	height: 640px;
	overflow-y: auto;
}

.location-box {
	border: 1px solid #ccc;
	padding: 10px;
	margin-bottom: 8px;
	cursor: pointer;
}

.location-box:hover {
	background-color: #f5f5f5;
}

h2 {
	margin: 0 3px 15px 3px;
}

select, input[type="text"] {
	margin-bottom: 10px;
	width: 100%;
}

#titleInput {
	font-size: 30px;
	font-weight: bold;
	margin-bottom: 20px;
	outline: none;
	border: none;
}

.location-box textarea {
	width: 100%;
	height: 60px;
	margin-top: 10px;
}

.location-box button {
	margin-top: 10px;
}

.next-button {
	padding: 10px;
	background-color: #0095f6;
	color: white;
	border: none;
	cursor: pointer;
	text-align: center;
	width: 100%;
	border-radius: 5px;
	margin-top: 15px;
	font-weight: 500;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
	font-size: 17px;
}

.next-button:hover {
	filter: brightness(110%);
	transition: filter 0.2s;
}

#daySelector {
	height: 30px;
	margin-bottom: 15px;
}
</style>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=565692454f10b190707ac97f8b7e88bf"></script>
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

	<div style="display: flex;">
		<div id="map"></div>
		<div class="sidebar">
			<%
			Schedule sc = (Schedule) session.getAttribute("sc");
			%>
			<%
			if (sc != null) {
			%>
			<div style="margin-bottom: 20px;">
				<input type="text" id="scheduleTitleInput" value="<%=sc.getName()%>"
					style="font-size: 20px; font-weight: bold; width: 100%;" />
				<p>
					여행 장소:
					<%=sc.getPlace_name()%></p>
				<p>
					여행 기간:
					<%=sc.getStart_date()%>
					~
					<%=sc.getEnd_date()%></p>
			</div>
			<%
			}
			%>

			<select id="daySelector" onchange="filterMarkersByDay()">
				<option value="">전체 보기</option>
				<option value="day1">Day 1</option>
				<option value="day2">Day 2</option>
				<option value="day3">Day 3</option>
			</select>
			<div id="locationList"></div>
			<button class="next-button" onclick="goToNextPage()">저장하기</button>
		</div>
	</div>

	<script>
const map = new kakao.maps.Map(document.getElementById('map'), {
	center: new kakao.maps.LatLng(37.5540728564304, 126.92060469962539),
	level: 3
});

const markers = [];
const markerData = [
	<%ArrayList<MarkerData> markers = (ArrayList<MarkerData>) session.getAttribute("savedMarkers");
if (markers != null) {
	for (MarkerData marker : markers) {
		String safeAddress = marker.getAddress().replace("'", "\\'");%>
	{
		markerId: '<%= marker.getMarkerId() %>',
		sd_code: '<%= marker.getSd_code() %>',
		lat: <%=marker.getLat()%>,
		lng: <%=marker.getLng()%>,
		address: '<%=safeAddress%>',
		day: '<%=marker.getDayS()%>',
		dayOrder: <%=marker.getDayOrder()%>,
		description: "<%=marker.getDescription() == null ? "" : marker.getDescription()%>"
	},
	<%}
}%>
];

function createMarker(lat, lng, address, day, dayOrder) {
	const position = new kakao.maps.LatLng(lat, lng);
	const kakaoMarker = new kakao.maps.Marker({
		position: position,
		map: map
	});

	const infoWindow = new kakao.maps.InfoWindow({
		content: '<div style="padding:5px;">' + day + ' - ' + dayOrder + '번째 장소<br>' + address + '</div>'
	});

	infoWindow.open(map, kakaoMarker);

	return { marker: kakaoMarker, info: infoWindow };
}

function displayLocationList(day) {
	const locationList = document.getElementById('locationList');
	locationList.innerHTML = '';

	const filteredMarkers = markerData.filter(marker => !day || marker.day === day);

	filteredMarkers.forEach((marker, index) => {
		const box = document.createElement('div');
		box.className = 'location-box';
		box.innerHTML =
			'<strong>' + marker.day + ' - ' + marker.dayOrder + '번째 장소</strong><br>' +
			'주소: ' + marker.address + '<br>' +
			'위도: ' + marker.lat + '<br>' +
			'경도: ' + marker.lng +
			'<textarea placeholder="부가 설명을 입력하세요" oninput="updateDescription(' + index + ', this.value)">' + marker.description + '</textarea>' +
			'<button onclick="goToLocation(' + marker.lat + ', ' + marker.lng + ')">이 위치로 이동</button>';

		box.onclick = function() {
			moveToMarker(marker.lat, marker.lng, marker.address);
		};

		locationList.appendChild(box);
	});
}

function moveToMarker(lat, lng, address) {
	const moveLatLon = new kakao.maps.LatLng(lat, lng);
	map.setCenter(moveLatLon);
	map.setLevel(3);
}

function updateDescription(index, value) {
	markerData[index].description = value;
}

function filterMarkersByDay() {
	const selectedDay = document.getElementById('daySelector').value;
	displayLocationList(selectedDay);
	updateMapMarkers(selectedDay);
}

function updateMapMarkers(day) {
	markers.forEach(marker => {
		marker.marker.setMap(null);
		marker.info.close();
	});
	markers.length = 0;

	const filteredMarkers = markerData.filter(marker => !day || marker.day === day);
	filteredMarkers.forEach(marker => {
		const newMarker = createMarker(marker.lat, marker.lng, marker.address, marker.day, marker.dayOrder);
		markers.push(newMarker);
	});
}

function getTripTitle() {
	return document.getElementById('scheduleTitleInput').value.trim();
}

function goToNextPage() {
	window.location.href = '<%=request.getContextPath()%>/myTrip';
	const tripTitle = getTripTitle();
	if (!tripTitle) {
		alert("일정 제목을 입력해주세요.");
		return;
	}

	const data = {
		title: tripTitle,
		markers: markerData
	};

	fetch('<%=request.getContextPath()%>/tripSet', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json; charset=UTF-8'
		},
		body: JSON.stringify(data)
	})
	.then(response => response.json())
	.then(data => {
		if (data.status === "success") {
			window.location.href = '<%=request.getContextPath()%>/myTrip';
		}
	})
	.catch(error => {
		console.error("전송 오류:", error);
	});
}

displayLocationList('');
updateMapMarkers('');
</script>

</body>
</html>
