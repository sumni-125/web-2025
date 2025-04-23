package tripMate.model;

public class MarkerData {
	private String markerId;
	private String sd_code;
	private String dayS;
	private String address;
	private double lat;
	private double lng;
	private int dayOrder;
	private String description;

	public MarkerData(String markerId, String sd_code, String dayS, String address, double lat, double lng,
			int dayOrder, String description) {
		this.markerId = markerId;
		this.sd_code = sd_code;
		this.dayS = dayS;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.dayOrder = dayOrder;
		this.description = description;
	}

	public String getMarkerId() {
		return markerId;
	}

	public void setMarkerId(String markerId) {
		this.markerId = markerId;
	}

	public String getSd_code() {
		return sd_code;
	}

	public void setSd_code(String sd_code) {
		this.sd_code = sd_code;
	}

	public String getDayS() {
		return dayS;
	}

	public void setDayS(String dayS) {
		this.dayS = dayS;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public int getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(int dayOrder) {
		this.dayOrder = dayOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MarkerData [markerId=" + markerId + ", sd_code=" + sd_code + ", dayS=" + dayS + ", address=" + address
				+ ", lat=" + lat + ", lng=" + lng + ", dayOrder=" + dayOrder + ", description=" + description + "]";
	}

}