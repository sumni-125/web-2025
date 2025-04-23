package tripMate.service;

import java.util.ArrayList;

import tripMate.model.Place;

public class PlaceService {

	public ArrayList<Place> getList(){
		ArrayList<Place> placeList = new ArrayList<>();
		
		placeList.add(new Place("서울", "https://img.freepik.com/free-photo/south-korea-skyline-seoul-best-view-south-korea-with-lotte-world-mall-namhansanseong-fortress_335224-495.jpg?semt=ais_hybrid&w=740"));
		placeList.add(new Place("경기", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/ba/cf/b5/photo4jpg.jpg?w=900&h=500&s=1"));
		placeList.add(new Place("인천", "https://img1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/wlQ/image/cQsUOe4KanRxdhIZFU7euD4mNfU.jpg"));
		placeList.add(new Place("강원", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkwuv2aGJyGDpEWyt_44782EPPWdtWGNMV1g&s"));
		placeList.add(new Place("부산", "https://media.istockphoto.com/id/467652752/ko/%EC%82%AC%EC%A7%84/%EB%B6%80%EC%82%B0-%EB%8F%84%EC%8B%9C.jpg?s=612x612&w=0&k=20&c=Xj61hoo6pSCEiBtLqy_zgJ9NnSQdGdqL59WWG4Sg59Y="));
		
		placeList.add(new Place("대구", "https://www.telltrip.com/wp-content/uploads/2025/03/Daegu-spring-attractions2.jpg"));
		placeList.add(new Place("광주", "https://cdn.latimes.kr/news/photo/202306/50425_60826_1836.png"));
		placeList.add(new Place("대전", "https://www.djto.kr/kor/resources/images/sub/d-light-daejeon-v2.jpg"));
		placeList.add(new Place("울산", "https://news.unist.ac.kr/kor/wp-content/uploads/2019/01/%EC%9A%B8%EC%82%B0%EB%8C%80%EA%B5%90%EC%A0%84%EB%A7%9D%EB%8C%80013_%EC%9A%B8%EC%82%B0%EC%8B%9C%EC%B2%AD-800x534.jpg"));
		placeList.add(new Place("충북", "https://image.ajunews.com/content/image/2023/06/01/20230601090154361816.jpg"));
		
		placeList.add(new Place("충남", "https://localsegye.co.kr/news/data/20240404/p1065617665115902_900_thum.jpg"));
		placeList.add(new Place("전북", "https://img1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/1jPF/image/ChaD_MisRC3T9VyDxHrf4iDKyNQ.jpg"));
		placeList.add(new Place("전남", "https://lh6.googleusercontent.com/proxy/_irTL2H0M9bNcnocPKo3oL3o2e8X7T_tLL7akyWlTdsjGJFad3h_XHRAtCFaYCvIxYIFnKizo_CPnW96geNFdDMMQvL6QbTOV_taPK9SIiiRfHMOxM2xYEUmNYlOZ_RxfWNEwjakb2LweGErsIQA"));
		placeList.add(new Place("경북", "https://cdn.kyongbuk.co.kr/news/photo/201901/1049722_331032_3238.jpg"));
		placeList.add(new Place("경남", "https://cdn.gnnews.co.kr/news/photo/202206/502888_287170_5034.jpg"));
		placeList.add(new Place("제주", "https://newsimg.hankookilbo.com/2018/03/29/201803291164451538_1.jpg"));
		
		return placeList;
	}
	
	
}
