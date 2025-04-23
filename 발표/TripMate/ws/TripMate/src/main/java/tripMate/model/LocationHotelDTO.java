package tripMate.model;

public class LocationHotelDTO {

	
	String title;
	int rate;
	int price;
	String address;
	String img_url;
	String location_id;
	
	
	

	public LocationHotelDTO(String title, int rate, int price, String address, String img_url,
			String location_id) {
		super();
		this.title = title;
		this.rate = rate;
		this.price = price;
		this.address = address;
		this.img_url = img_url;
		this.location_id = location_id;
	}
	
	


	public int getRate() {
		return rate;
	}




	public void setRate(int rate) {
		this.rate = rate;
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	public String getLocation_id() {
		return location_id;
	}


	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}




	@Override
	public String toString() {
		return "LocationHotelDTO [title=" + title + ", rate=" + rate + ", price=" + price + ", address=" + address
				+ ", img_url=" + img_url + ", location_id=" + location_id + "]";
	}


	
	
	
}
