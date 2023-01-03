package com.booking.entry;

public class addFlight {
	private String flight_number;
	private String city_from;
	private String city_to;
	
	public addFlight() {
		
	}
	
	public addFlight(String flight_number, String city_from, String city_to) {
		super();
		this.flight_number = flight_number;
		this.city_from = city_from;
		this.city_to = city_to;
	}


	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getCity_from() {
		return city_from;
	}

	public void setCity_from(String city_from) {
		this.city_from = city_from;
	}

	public String getCity_to() {
		return city_to;
	}

	public void setCity_to(String city_to) {
		this.city_to = city_to;
	}


}
