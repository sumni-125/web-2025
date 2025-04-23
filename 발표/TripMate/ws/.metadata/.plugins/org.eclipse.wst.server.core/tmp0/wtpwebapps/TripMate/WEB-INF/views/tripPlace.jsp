<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 선택</title>
<link href="css/header.css" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap');
* {
	font-family: "Noto Sans KR", serif;
	font-optical-sizing: auto;
	font-weight: 400;
	font-style: normal;
}

	body, html{
		padding: 0;
		margin: 0;
	}
	
	.wrap{
	width: 100%;
	height: 100%;
	background-color:#f5f5f5;
	}
	
	.title{
		margin-left: 200px;
		display: flex;
	}
	.title h1{
		font-size: 50px;
		font-weight: bold;
	}
	.title p{
		font-size: 20px;
		margin: 0px;
		transform: translate(30px,70px);
	}
	
	.place-list{
		background-color: white; 
		width: 1200px;
		
		border-radius: 3px;
		padding: 30px 0;
		margin: 0px auto;

		display: flex;
		flex-wrap: wrap;
		justify-content: center;
		box-shadow: 0 2px 8px rgba(0,0,0,0.2);
	}

	.place{
		border-radius: 100px;
		width: 200px;
		height: 200px;
		margin: 20px 45px;
		position: relative;
	}

	.place img{
		border-radius: 100px;
		width: 200px;
		height: 200px;
		object-fit: cover;
		box-shadow: 0 2px 8px rgba(0,0,0,0.4);
		transition: 0.2s;
	}
	
	.place:hover img{
		cursor: pointer;
		opacity: 0.5;
	}
	
	.place-name{
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		font-weight: bold;
		font-size: 35px;
		color: white; 
		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
	}
	 
	.place:hover .place-name{
		color: black;
		text-shadow: none;
	}
	
	#prev-btn, #complete-btn{
		width: 180px;
		height: 45px; 
		padding: 10px 20px;
		border-radius: 5px;
		text-align: center;
		font-weight: 500;
		font-size: 28px;
		box-shadow: 0 2px 8px rgba(0,0,0,0.3);
	}
	
	#prev-btn:hover, #complete-btn:hover{
		cursor: pointer;
		filter: brightness(110%);
	}
	
	#prev-btn{
		background-color: white;
	}
	
	#complete-btn{
		background-color: #0095F6;
		color: white;	
	}
	
	.btn-wrap{
		display:flex;
		padding: 40px 0;
		margin: 0px 160px;
		justify-content: space-between;
	}
	
	.place.selected {
    	opacity: 0.7;
    	box-shadow: 0 0 0 6px #0095F6;;
}
	
	
</style>
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
<div class="wrap">
	<div class="title">
	<h1>여행지 선택</h1>
	<p>어디로 여행을 갈까요?</p>
	</div>
	<div class="place-list">
		<c:forEach var="place" items="${placeList}">
	    <div class="place">
		    <div class="place-name">${place.name}</div>
		    <img src="${place.imgUrl}" alt="${place.name}" type="button" class="place-btn" data-name="${place.name}">
	    
<!--<button type="button" class="place-btn" data-name="${place.name}">${place.name}</button>-->

		</div>
	    </c:forEach>
	</div>
    <div id="selected-places"></div>
    <div class="btn-wrap">
    	<div type="button" id="prev-btn" onclick="location.href='#'">이전</div>
    	<div type="button" id="complete-btn">다음</div>
	</div>
</div>
	
<script>
	
	let selectedPlace = null;
	
	document.querySelectorAll('.place-btn').forEach(btn => {
	 btn.onclick = function() {
	     
		 //이전에 선택한 여행지가 있으면?? 그거 선택해제
	     document.querySelectorAll('.place').forEach(div => {
	         div.classList.remove('selected');
	     });
	
	     //새로 선택한거 표시
	     selectedPlace = btn.dataset.name;
	     btn.parentElement.classList.add('selected');
	     showSelected();
	 }
	});
	
	function showSelected() {
	 const box = document.getElementById('selected-places');
	 box.innerHTML = '';
	 
	 
	}
	
	document.getElementById('complete-btn').onclick = function() {
	 if (!selectedPlace) {
	     alert('여행지를 하나 선택해주세요.');
	     return;
	 }
	 //확인용
	 alert('선택 완료: ' + selectedPlace);
	 location.href='<%=request.getContextPath()%>/tripCal';
	 //다음페이지 넘어가게해야도ㅣㅁ
};




/*
const selected = new Set();

document.querySelectorAll('.place-btn').forEach(btn => {
    btn.onclick = function() {
    	
        const name = btn.dataset.name;
        if (!selected.has(name)) {
            selected.add(name);
            showSelected();
        }
    }
});


function showSelected() {
    const box = document.getElementById('selected-places');
    box.innerHTML = '';
    
    selected.forEach(name => {
        const div = document.createElement('div');
        div.textContent = name + ' ';
        
        const del = document.createElement('button');
        del.textContent = '삭제';
        del.onclick = function() {
            selected.delete(name);
            showSelected();
        };
        
        div.appendChild(del);
        box.appendChild(div);
    });
}


document.getElementById('complete-btn').onclick = function() {
   
	if(selected.size == 0) {
        alert('여행지를 선택하세요.');
        return;
    }
	
    alert('선택 완료: ' + Array.from(selected).join(', '));

};
*/
</script>
</body>
</html>
