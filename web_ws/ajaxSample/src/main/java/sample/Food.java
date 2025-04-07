package sample;

public class Food {
	
	String name;
	String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Food(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + "]";
	}
	
	 public Food() {
		// TODO Auto-generated constructor stub
	}

}
