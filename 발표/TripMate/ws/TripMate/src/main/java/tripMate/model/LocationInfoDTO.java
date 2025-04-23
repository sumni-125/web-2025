package tripMate.model;

public class LocationInfoDTO {
	
	String title;
	String content;
	String img_url;
	String address;
	String location_id;
	
	
	public LocationInfoDTO(String title, String content, String img_url, String address, String location_id) {
		super();
		this.title = title;
		this.content = content;
		this.img_url = img_url;
		this.address = address;
		this.location_id = location_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLocation_id() {
		return location_id;
	}


	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}


	@Override
	public String toString() {
		return "LocationInfoDTO [title=" + title + ", content=" + content + ", img_url=" + img_url + ", address="
				+ address + ", location_id=" + location_id + "]";
	}
	
	
	

}
