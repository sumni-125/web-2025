<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>여행 지도</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="css/map.css" rel="stylesheet">
	<link href="css/header.css" rel="stylesheet">
</head>
<body>
<header>
	<div class="logo">
		<a href="<%=request.getContextPath()%>/main"><img class="logoImg" src="image/logo.png" alt=""></a>
	</div>
	<div><a href="<%=request.getContextPath()%>/myTrip">여행일정</a></div>
	<div><a href="">관광지</a></div>
	<div><a href="">블로그</a></div>
	<div><a href="<%=request.getContextPath()%>/myPage">마이페이지</a></div>
</header>

<div class="map_wrap">
	<div id="map"></div>
	<div class="side">
		<div id="clickLatlng">📍 마커 위치: 없음</div>
		<select id="daySelector" onchange="filterMarkersByDay()"></select>
		<button onclick="saveMarker()">저장</button>
		<div id="savedCoords"></div>
		<button id="nextButton" onclick="sendMarkersToServer()">다음</button>
	</div>
</div>

<!-- Kakao 지도 API -->
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=565692454f10b190707ac97f8b7e88bf&libraries=services"></script>

<script>
	const dayList = JSON.parse('<%=request.getAttribute("dayListJson")%>');
	const sd_code = '<%= request.getAttribute("sd_code") %>';

	const daySelector = document.getElementById('daySelector');
	dayList.forEach((day, idx) => {
		const option = document.createElement('option');
		option.value = day;
		option.textContent = "Day " + (idx + 1);
		daySelector.appendChild(option);
	});

	const map = new kakao.maps.Map(document.getElementById('map'), {
		center: new kakao.maps.LatLng(37.5540728564304, 126.92060469962539),
		level: 3
	});
	const geocoder = new kakao.maps.services.Geocoder();

	let tempMarker = null;
	let tempInfoWindow = null;
	const savedMarkers = [];

	kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
		const latlng = mouseEvent.latLng;
		geocoder.coord2Address(latlng.getLng(), latlng.getLat(), function (result, status) {
			if (status === kakao.maps.services.Status.OK) {
				const roadAddr = result[0].address.address_name;
				const content = '<div class="preview-info">' + roadAddr + '</div>';

				if (tempMarker) tempMarker.setMap(null);
				if (tempInfoWindow) tempInfoWindow.close();

				tempMarker = new kakao.maps.Marker({ position: latlng, map: map });
				tempInfoWindow = new kakao.maps.InfoWindow({ content: content, position: latlng });
				tempInfoWindow.open(map, tempMarker);

				tempMarker.roadAddress = roadAddr;
				tempMarker.latlng = latlng;

				document.getElementById('clickLatlng').innerHTML = '📍 주소: ' + roadAddr;
			}
		});
	});

	function saveMarker() {
		if (!tempMarker) return;

		const latlng = tempMarker.latlng;
		const roadAddr = tempMarker.roadAddress;
		const selectedDay = document.getElementById('daySelector').value;

		const savedMarker = new kakao.maps.Marker({ position: latlng, map: map });

		savedMarkers.push({
			marker: savedMarker,
			info: null,
			address: roadAddr,
			latlng: latlng,
			day: selectedDay,
			description: ""
		});

		updateLocationList();

		tempMarker.setMap(null);
		tempInfoWindow.close();
		tempMarker = null;
		tempInfoWindow = null;

		document.getElementById('clickLatlng').innerHTML = '📍 마커 위치: 없음';
	}

	function deleteMarker(index) {
		savedMarkers[index].marker.setMap(null);
		if (savedMarkers[index].info) savedMarkers[index].info.close();
		savedMarkers.splice(index, 1);
		updateLocationList();
	}

	function updateLocationList() {
		const selectedDay = document.getElementById('daySelector').value;
		const savedCoords = document.getElementById('savedCoords');
		savedCoords.innerHTML = '';
		let count = 1;

		savedMarkers.forEach((marker, index) => {
			if (marker.day === selectedDay) {
				const lat = marker.latlng.getLat().toFixed(6);
				const lng = marker.latlng.getLng().toFixed(6);

				if (marker.info) marker.info.close();
				const infoWindow = new kakao.maps.InfoWindow({
					content: '<div class="saved-info">' + count + '번째 장소<br>' + marker.address + '</div>',
					position: marker.latlng
				});
				infoWindow.open(map, marker.marker);
				marker.info = infoWindow;

				const box = document.createElement('div');
				box.className = 'saved-location';
				box.innerHTML =
					'<div>' + count + '번째 장소</div>' +
					'<div>주소: ' + marker.address + '</div>' +
					'<div>위도: ' + lat + '</div>' +
					'<div>경도: ' + lng + '</div>' +
					'<input type="text" class="nickname-input" placeholder="위치 설명" oninput="updateNickname(' + index + ', this.value)" />' +
					'<button onclick="deleteMarker(' + index + ')">삭제</button>';
				savedCoords.appendChild(box);
				count++;
			} else {
				if (marker.info) marker.info.close();
			}
		});
	}

	function filterMarkersByDay() {
		const selectedDay = document.getElementById('daySelector').value;
		savedMarkers.forEach(marker => {
			if (marker.day === selectedDay) {
				marker.marker.setMap(map);
				if (marker.info) marker.info.setMap(map);
			} else {
				marker.marker.setMap(null);
				if (marker.info) marker.info.setMap(null);
			}
		});
		updateLocationList();
	}

	function updateNickname(index, value) {
		savedMarkers[index].description = value;
	}

	function sendMarkersToServer() {
		const groupedByDay = {};
		savedMarkers.forEach(marker => {
			if (!groupedByDay[marker.day]) groupedByDay[marker.day] = [];
			groupedByDay[marker.day].push(marker);
		});

		const markersData = [];
		Object.keys(groupedByDay).forEach(day => {
			groupedByDay[day].forEach((marker, index) => {
				markersData.push({
					markerId: "", // 서버에서 생성하거나 UUID 생성 가능
					sd_code: sd_code,
					dayS: day,
					address: marker.address,
					lat: marker.latlng.getLat(),
					lng: marker.latlng.getLng(),
					dayOrder: index + 1,
					description: marker.description || ""
				});
			});
		});

		console.log("전송할 마커 데이터:", markersData);

		fetch('<%=request.getContextPath()%>/tripMap', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json; charset=UTF-8' },
			body: JSON.stringify(markersData)
		})
			.then(response => response.json())
			.then(data => {
				if (data.status === "success") {
					console.log("서버 전송 성공");
					window.location.href = '<%=request.getContextPath()%>/tripSet';
				}
			})
			.catch(error => {
				console.error('전송 실패:', error);
			});
	}
</script>
</body>
</html>
