package day08Prac;

public class 페이지구하기 {
	/*
	 * (페이징을 위해 주어진 조건) 
	 * 현재페이지: 1 
	 * 목록의개수 :5 ( 한 페이지에 보이는 글의 수) 
	 * 총레코드수 : 46 페이징그룹사이즈 :4
	 * 총페이지수 구하기 : 
	 * 현재그룹구하기 : 
	 * 현재그룹시작번호구하기 : 
	 * 현재그룹마지막번호구하기 : 
	 * 
	 * 2.(페이징을 위해 주어진 조건) 
	 * 현재페이지:6 
	 * 목록의개수 :4 
	 * 총레코드수 : 37 
	 * 페이징그룹사이즈 :5 
	 * 총페이지수 구하기 : 
	 * 현재그룹구하기 : 
	 * 현재그룹시작번호구하기 :
	 * 현재그룹마지막번호구하기 :
	 * 
	 * 3. (페이징을 위해 주어진 조건) 
	 * 현재페이지:13 
	 * 목록의개수 :10 
	 * 총레코드수 : 153 
	 * 페이징그룹사이즈 :4
	 * 총페이지수 구하기 : 
	 * 현재그룹구하기 : 
	 * 현재그룹시작번호구하기 : 
	 * 현재그룹마지막번호구하기 :
	 * 
	 * 4. (페이징을 위해 주어진 조건) 
	 * 현재페이지:9 
	 * 목록의개수 : 7 
	 * 총레코드수 : 513 
	 * 페이징그룹사이즈 : 6 
	 * 총페이지수 구하기 
	 * 현재그룹구하기 
	 * 현재그룹시작번호구하기
	 * 현재그룹마지막번호구하기
	 */
	
	public static void main(String[] args) {
		
		int currentPage=1;
		int pageSize=5;
		int totRecords=46;
		int grpSize=4;
		
		int remain = totRecords%pageSize;
		int totalPage;
		
		if(remain==0) {
			totalPage=totRecords/pageSize;
		}else {
			totalPage = totRecords/pageSize +1;
		}
		
		int remain2 = currentPage% grpSize;
		int currentGrp;
		
		if(remain2==0) {
			currentGrp=currentPage/grpSize;
		}else {
			currentGrp = currentPage/grpSize +1;
		}
		
		int grpEndPage;
		int grpStartPage;
		
		grpStartPage=(currentGrp-1)*grpSize+1;
		grpEndPage=currentPage*grpSize;
		
		// 마지막 확인(그룹의 마지막 페이지가 전체 페이지수보다 크면 그룹마지막을 전체페이지 수로 변경)
		
		if(grpEndPage>totalPage) {
			grpEndPage=totalPage;
		}
		
		System.out.println("totalPage "+totalPage);
		System.out.println("currentGrp "+currentGrp);
		System.out.println("grpStartPage "+grpStartPage);
		System.out.println("grpEndPage "+grpEndPage);
		
		

	}
	
	
	
}
