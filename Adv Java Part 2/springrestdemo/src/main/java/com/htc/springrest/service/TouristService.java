package com.htc.springrest.service;

import java.util.List;

import com.htc.springrest.resource.TouristPlace;


public interface TouristService {

	public boolean addTouristPlace(TouristPlace place);
	public TouristPlace getTouristPlace(String placeName);
	public List<TouristPlace> getAllTouristPlaces(String state);
	public boolean updateTouristPlace(String placeName, TouristPlace tp);
	public boolean deleteTouristPlace(String placeName);
}
