package library;

public class Library {

	
	String seat_id;
	String seat_position;
	String seat_status;
	
	
	public Library(String seat_id, String seat_position, String seat_status) {
		super();
		this.seat_id = seat_id;
		this.seat_position = seat_position;
		this.seat_status = seat_status;
	}
	
	public Library() {
		// TODO Auto-generated constructor stub
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public void setSeat_position(String seat_position) {
		this.seat_position = seat_position;
	}

	public void setSeat_status(String seat_status) {
		this.seat_status = seat_status;
	}

	public String getSeat_id() {
		return seat_id;
	}

	public String getSeat_position() {
		return seat_position;
	}

	public String getSeat_status() {
		return seat_status;
	}

	@Override
	public String toString() {
		return "Library [seat_id=" + seat_id + ", seat_position=" + seat_position + ", seat_status=" + seat_status
				+ "]";
	}
	
	
	
	
	
	
}
