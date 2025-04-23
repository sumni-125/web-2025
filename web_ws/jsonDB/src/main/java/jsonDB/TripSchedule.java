package jsonDB;

import java.util.List;

public class TripSchedule {
    private String destination;
    private String start_date;
    private String end_date;
    private List<Plan> plans;
    public TripSchedule() {}  // Jackson이 필요로 함!
    
    
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}


	@Override
	public String toString() {
		return "TripSchedule [destination=" + destination + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", plans=" + plans + "]";
	}

    // Getter / Setter
    
    
	
    
} 

/*
class Plan {
    private int day;
    private String place;
    private String activity;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	@Override
	public String toString() {
		return "Plan [day=" + day + ", place=" + place + ", activity=" + activity + "]";
	}
	
 
	

	
}*/
 class Plan {
    private int day;
    private double latitude;
    private double longitude;
    private String address;
    // getters, setters
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
}


    // Getter / Setter
    
