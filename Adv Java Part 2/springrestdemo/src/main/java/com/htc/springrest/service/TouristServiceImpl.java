package com.htc.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.TooManyRequests;

import com.htc.springrest.dao.TouristDAO;
import com.htc.springrest.resource.TouristPlace;

@Service
public class TouristServiceImpl implements TouristService{

	@Autowired
	TouristDAO touristDAO;
	
	@Override
	public TouristPlace getTouristPlace(String placeName) {
		///........
		return touristDAO.getTouristPlace(placeName);
	}

	@Override
	public List<TouristPlace> getAllTouristPlaces(String state) {
		return touristDAO.getAllTouristPlaces(state);
	}

	@Override
	public boolean addTouristPlace(TouristPlace place) {
		
		return touristDAO.addTouristPlace(place);
	}

	@Override
	public boolean updateTouristPlace(String placeName, TouristPlace tp) {
		return touristDAO.updateTouristPlace(placeName, tp);
	}

	@Override
	public boolean deleteTouristPlace(String placeName) {
		return touristDAO.deleteTouristPlace(placeName);
	}

	
}
