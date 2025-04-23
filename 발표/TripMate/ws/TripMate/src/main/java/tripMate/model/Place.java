package tripMate.model;

public class Place {

	String name;
	String imgUrl;

	public Place(String name, String imgUrl) {
		super();
		this.name = name;
		this.imgUrl = imgUrl;
	}

	public Place() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Place [name=" + name + ", imgUrl=" + imgUrl + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
