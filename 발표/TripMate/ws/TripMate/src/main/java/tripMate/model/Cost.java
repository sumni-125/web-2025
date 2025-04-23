package tripMate.model;

public class Cost {
	private String costId; // 지출 고유키 - C00001
	private String tripCode; // 여행 고유키(외래키) - T00001
	private String tripDate; // 날짜
	private String category; // 카테고리(숙박, 항공, 교통, 식사, 관광, 쇼핑, 기타)
	private String location; // 장소
	private int amount; // 결제 금액
	private String paymentType; // 결제수단: 카드 or 현금
	private String payerCode; // 결제자코드 - U00001
	private String payerNickname; // 닉네임 따로저장
	private String paymentMethod; // 결제방식: 1/N, 한번에결제, 개인결제

	public Cost() {
	}

	// 지출내역(cost): 날짜, 카테고리, 장소, 결제금액, 결제방식
	public Cost(String tripDate, String category, String location, int amount, String paymentMethod) {
		super();
		this.tripDate = tripDate;
		this.category = category;
		this.location = location;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}

	// 소비기록추가(CostAdd): 지출내역 + 결제수단, 결제자
	public Cost(String tripDate, String category, String location, int amount, String paymentType, String payerCode,
			String paymentMethod) {
		super();
		this.tripDate = tripDate;
		this.category = category;
		this.location = location;
		this.amount = amount;
		this.paymentType = paymentType;
		this.payerCode = payerCode;
		this.paymentMethod = paymentMethod;
	}

	// 전체 생성자
	public Cost(String costId, String tripCode, String tripDate, String category, String location, int amount,
			String paymentType, String payerCode, String payerNickname, String paymentMethod) {
		super();
		this.costId = costId;
		this.tripCode = tripCode;
		this.tripDate = tripDate;
		this.category = category;
		this.location = location;
		this.amount = amount;
		this.paymentType = paymentType;
		this.payerCode = payerCode;
		this.payerNickname = payerNickname;
		this.paymentMethod = paymentMethod;
	}

	// --- getters & setters ---
	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public String getTripCode() {
		return tripCode;
	}

	public void setTripCode(String tripCode) {
		this.tripCode = tripCode;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerNickname() {
		return payerNickname;
	}

	public void setPayerNickname(String payerNickname) {
		this.payerNickname = payerNickname;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
