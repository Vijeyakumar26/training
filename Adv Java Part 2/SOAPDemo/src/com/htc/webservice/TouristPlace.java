package com.htc.webservice;

import java.util.Arrays;

public class TouristPlace
{
	private String placeName;
	private String city;
	private String State;
	private String[] touristSpotNames;
	
	
	public TouristPlace() {
		super();
	}

	public TouristPlace(String placeName, String city, String state, String[] touristSpotNames) {
		super();
		this.placeName = placeName;
		this.city = city;
		State = state;
		this.touristSpotNames = touristSpotNames;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String[] getTouristSpotNames() {
		return touristSpotNames;
	}
	public void setTouristSpotNames(String[] touristSpotNames) {
		this.touristSpotNames = touristSpotNames;
	}
	
	@Override
	public String toString() {
		return "TouristPlace [placeName=" + placeName + ", city=" + city + ", State=" + State + ", touristSpotNames="
				+ Arrays.toString(touristSpotNames) + "]";
	}
}
