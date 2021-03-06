package com.htc.springrestclient.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.htc.springrestclient.resource.TouristPlace;


public class TouristServiceClient {

	public static String getTouristPlaceURL = "http://localhost:8080/TouristPlaces/";
	public static String getAllTouristPlacesURL = "http://localhost:8080/TouristPlaces/States/";
	public static String addTouristPlaceURL = "http://localhost:8080/TouristPlaces";
	public static String updateTouristPlaceURL = "http://localhost:8080/TouristPlaces/Update/";
	public static String deleteTouristPlaceURL = "http://localhost:8080/TouristPlaces/Delete/";

	public static void main(String[] args) {


		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);

		//add
		ResponseEntity<Boolean> res = template.postForEntity(addTouristPlaceURL, new TouristPlace("Mysore4","Mysore", "Karnataka", new String[]{"place1","plce2"}) , Boolean.class);
		System.out.println(res.getBody());

		ResponseEntity<TouristPlace> response = template.getForEntity(getTouristPlaceURL+"Mysore", TouristPlace.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders().toString());



		//getAll		
		ResponseEntity<List<TouristPlace>> result =
				template.exchange(getAllTouristPlacesURL+"Karnataka", 
						HttpMethod.GET, 
						entity, 
						new ParameterizedTypeReference<List<TouristPlace>>(){});

		System.out.println(result.getBody().toString());

		//update
		TouristPlace TouristPlace = new TouristPlace();
		TouristPlace.setCity("Mysore City1");
		TouristPlace.setState("Karnataka12");
		template.put(updateTouristPlaceURL+"Mysore", TouristPlace);

		//delete
		//		ResponseEntity<TouristPlace> del = template.exchange(deleteTouristPlaceURL+"Mysore4",HttpMethod.DELETE,null, TouristPlace.class);
		//		System.out.println(del.getBody());

		ResponseEntity<Boolean> delete =template.exchange(deleteTouristPlaceURL+"Mysore4", 
				HttpMethod.DELETE, 
				entity, 
				new ParameterizedTypeReference<Boolean>(){});
	}
}
