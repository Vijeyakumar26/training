package com.htc.webservice.client;

import java.util.List;

import com.htc.webservice.helper.TouristPlace;
import com.htc.webservice.helper.TouristService;
import com.htc.webservice.helper.TouristServiceImplService;

public class SOAPClient {

	public static void main(String[] args) {
		TouristServiceImplService service = new TouristServiceImplService();
		TouristService ts = service.getTouristServiceImplPort();
	
		
		List<TouristPlace> placeList = ts.getAllTouristPlaces("Kerala");
		System.out.println(placeList);
		
		TouristPlace tp = ts.getTouristPlaceDetails("Mysore");
		System.out.println(tp);
		
	}
}
