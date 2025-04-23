package Product;

public class filterproductDTO {

	private int product_id;
	String title;
	String image_path;
	int currentprice;
	String register_date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public int getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(int currentprice) {
		this.currentprice = currentprice;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public filterproductDTO() {
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public filterproductDTO(int product_id, String title, String image_path, int currentprice, String register_date) {
		this.product_id = product_id;
		this.title = title;
		this.image_path = image_path;
		this.currentprice = currentprice;
		this.register_date = register_date;
	}


	@Override
	public String toString() {
		return "filterproductDTO [title=" + title + ", image_path=" + image_path + ", currentprice=" + currentprice
				+ ", register_date=" + register_date + "]";
	}
}
