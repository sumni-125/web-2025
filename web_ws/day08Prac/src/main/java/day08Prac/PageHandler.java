package day08Prac;

public class PageHandler {

	int pageSize; // 한 페이지의 글의 수
	int grpSize; // 그룹의 사이즈
	int totRecords; // 전체 레코드 수
	int currentPage; // 현재 페이지
	int currentGrp; // 현재 그룹
	int grpEndPage; // 그룹의 끝
	int grpStartPage; // 그룹의 시작
	int totalPage; // 전체페이지 수

	public PageHandler(int pageSize, int grpSize, int totRecords, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		this.totRecords = totRecords;
		this.currentPage = currentPage;

		calc();
	}

	private void calc() {

		// 나머지가 있는 경우
		int remain = totRecords % pageSize;

		if (remain == 0) {
			totalPage = totRecords / pageSize;
		} else { // 나머지가 있는 경우
			totalPage = totRecords / pageSize + 1;
		}

		// 현재페이지에 대한 => 현재그룹 구하기
		int remain2 = currentPage % grpSize;

		if (remain2 == 0) {
			currentGrp = currentPage / grpSize;
		} else {
			currentGrp = currentPage / grpSize + 1;
		}

		// 현재그룹의 시작, 끝
		grpStartPage = (currentGrp - 1) * grpSize + 1;
		grpEndPage = currentGrp * grpSize;

		// 마지막 확인 (그룹의 마지막페이지가 전체페이지수보다 크다면 그룹의 마지막을 전체페이지수로 변경한다)
		if (grpEndPage > totalPage) { // 10 > 9
			grpEndPage = totalPage;
		}

	}

	public int getPageSize() {
		return pageSize;
	}
	public int getGrpSize() {
		return grpSize;
	}
	public int getTotRecords() {
		return totRecords;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getCurrentGrp() {
		return currentGrp;
	}
	public int getGrpEndPage() {
		return grpEndPage;
	}
	public int getGrpStartPage() {
		return grpStartPage;
	}
	public int getTotalPage() {
		return totalPage;
	}

	// 33 /5 => 6 +1 =>7
	public static void main(String[] args) {
		// (int pageSize, int grpSize, int totRecords, int currentPage) {
		PageHandler p = new PageHandler(5, 4, 33, 6);

		int currentGrp = p.getCurrentGrp();
		int grpStart = p.getGrpStartPage();
		int grpEng = p.getGrpEndPage();

		System.out.println(currentGrp);
		System.out.println(grpStart);
		System.out.println(grpEng);

	}

}
