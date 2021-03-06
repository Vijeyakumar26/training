package com.htc.soapjdbcclient.main;

import com.htc.soapjdbcclient.helper.TouristService;
import com.htc.soapjdbcclient.helper.TouristServiceImplService;

public class MainClient {
	
	public static void main(String[] args) {
		
		TouristServiceImplService service = new TouristServiceImplService();
		TouristService ts = service.getTouristServiceImplPort();
		
		System.out.println(ts.getTouristPlaceDetails("Agra"));
		
		//System.out.println(ts.getAllTouristPlaces("Karnataka")); 
		
	}

}
