package tripMate.model;

public class SearchDTO {

	
	String id;
	String location;
	String img_url;
	
	
	
	public SearchDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SearchDTO(String id, String location, String img_url) {
		super();
		this.id = id;
		this.location = location;
		this.img_url = img_url;
	}


	public SearchDTO(String id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	
	
	public SearchDTO(String location) {
		
		this.location = location;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	

	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	@Override
	public String toString() {
		return location;
	}
	
	
	
	
}
