package com.htc.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.springrest.resource.TouristPlace;
import com.htc.springrest.service.TouristService;

@RestController
public class TouristController {

	@Autowired
	TouristService touristService;
	
//	@GetMapping(value="/TouristPlaces/{placeName}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public TouristPlace getTouristPlaceDetails(@PathVariable(name="placeName") String placeName) {
//		System.out.println();
//		return touristService.getTouristPlace(placeName);
//	}
//	
//	@GetMapping(value="/TouristPlaces/States/{state}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<TouristPlace> getAllTouristPlaces(@PathVariable(name="state") String state) {
//		return touristService.getAllTouristPlaces(state);
//	}
//	
//	@PostMapping(value="/TouristPlaces/", consumes=MediaType.APPLICATION_JSON_VALUE)
//	public boolean addTouristPlace(@RequestBody TouristPlace place) {
//		return touristService.addTouristPlace(place);
//	}
//	
//	@PutMapping(value="/TouristPlaces/Update/{placeName}", consumes=MediaType.APPLICATION_JSON_VALUE)
//	public boolean updateTouristPlace(@PathVariable(name="placeName") String placeName, @RequestBody TouristPlace tp) {
//		
//		return touristService.updateTouristPlace(placeName, tp);
//	}
//	
//	@DeleteMapping(value="/TouristPlaces/Delete/{placeName}")
//	public boolean deleteTouristPlace(@PathVariable(name="placeName") String placeName) {
//		
//		return touristService.deleteTouristPlace(placeName);
//	}
	
	@GetMapping(value="/TouristPlaces/{placeName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TouristPlace> getTouristPlaceDetails(@PathVariable(name="placeName") String placeName) {

		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		TouristPlace tp = touristService.getTouristPlace(placeName);
		if(tp ==null) {
			ResponseEntity<TouristPlace> response = new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
			return response;
		}
		else {
			ResponseEntity<TouristPlace> response = new ResponseEntity<TouristPlace>(tp , header, HttpStatus.OK);
			return response;			
		}
	}
	
	@GetMapping(value="/TouristPlaces/States/{state}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TouristPlace>> getAllTouristPlaces(@PathVariable(name="state") String state) {

		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		
		List<TouristPlace> placeList = touristService.getAllTouristPlaces(state);
		ResponseEntity<List<TouristPlace>> response = new ResponseEntity<>(placeList, header, HttpStatus.OK);
		return response;
	}
	
	@PostMapping(value="/TouristPlaces", consumes=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> addTouristPlace(@RequestBody TouristPlace place) {
		
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		
		boolean result =  touristService.addTouristPlace(place);
		return new ResponseEntity<Boolean>(result, header, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/TouristPlaces/Update/{placeName}", consumes=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> updateTouristPlace(@PathVariable(name="placeName") String placeName, @RequestBody TouristPlace tp) 
	{
		
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");
		

		boolean result =  touristService.updateTouristPlace(placeName, tp);
		return new ResponseEntity<Boolean>(result, header, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/TouristPlaces/Delete/{placeName}")
	public ResponseEntity<Boolean> deleteTouristPlace(@PathVariable(name="placeName") String placeName) {
		
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");
		

		boolean result =  touristService.deleteTouristPlace(placeName);
		return new ResponseEntity<Boolean>(result, header, HttpStatus.OK);
	}
}
