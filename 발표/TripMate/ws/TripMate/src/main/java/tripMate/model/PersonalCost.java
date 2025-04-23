package tripMate.model;

public class PersonalCost {

	private String personalCostId; // 정산 고유키 - P00001
	private String costId; // 지출 고유키(외래키) - C00001
	private String userCode; // 유저 고유키(외래키) - U00001
	private int personCost; // 개인 비용
	private String status; // "정산대기중" or "정산완료"
	private String payer; // 결제자
	private String payerCode; // 결제자 코드

	public PersonalCost() {
	}

	// 개인 정산 내역(personalCost): 이름, 할당금액, 정산상태
	public PersonalCost(String userCode, int personCost, String status, String payer) {
		super();
		this.userCode = userCode;
		this.personCost = personCost;
		this.status = status;
		this.payer = payer;
	}

	// 전체 생성자
	public PersonalCost(String personalCostId, String costId, String userCode, int personCost, String status,
			String payer, String payerCode) {
		super();
		this.personalCostId = personalCostId;
		this.costId = costId;
		this.userCode = userCode;
		this.personCost = personCost;
		this.status = status;
		this.payer = payer;
		this.payerCode = payerCode;
	}

	// --- getters & setters ---
	public String getPersonalCostId() {
		return personalCostId;
	}

	public void setPersonalCostId(String personalCostId) {
		this.personalCostId = personalCostId;
	}

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getPersonCost() {
		return personCost;
	}

	public void setPersonCost(int personCost) {
		this.personCost = personCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

}
