package tripMate.model;

public class TripMember {

	private String sdCode; // 여행 고유키 (T00001)
	private String userCode; // 사용자 고유키 (U00001)

	public TripMember() {
	}

	public TripMember(String sdCode, String userCode) {
		this.sdCode = sdCode;
		this.userCode = userCode;
	}

	public String getSdCode() {
		return sdCode;
	}

	public void setSdCode(String sdCode) {
		this.sdCode = sdCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
