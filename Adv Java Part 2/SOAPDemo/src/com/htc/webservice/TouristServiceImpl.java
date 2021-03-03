package com.htc.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="com.htc.webservice.TouristService")
public class TouristServiceImpl	implements TouristService
{
	//Datastore
	List<TouristPlace> touristPlaces = new ArrayList<TouristPlace>();

	public TouristServiceImpl() {
		touristPlaces.add(new TouristPlace("Mysore", "Mysore", "Karnataka", new String[] {"MySore Palace", "Zoo", "Bird Sanctury","Temple"}));
		touristPlaces.add(new TouristPlace("Bangalore", "Bangalore", "Karnataka", new String[] {"Park", "Temple"}));
		touristPlaces.add(new TouristPlace("Cochin", "Cochin", "Kerala", new String[] {"Back waters", "Park", "Bird Sanctury","Temple"}));
	}

	@Override
	public TouristPlace locateTouristPlace(String touristPlace) 
	{
		TouristPlace place = null;
		for(TouristPlace tp: touristPlaces) 
		{
			if(tp.getPlaceName().equals(touristPlace)) 
			{
				place = tp;
				break;
			}
		}
		return place;
	}

	@Override
	public List<TouristPlace> findTouristPlaces(String state) 
	{
		List<TouristPlace> placeList = new ArrayList<TouristPlace>();
		for(TouristPlace tp : touristPlaces) 
		{
			if(tp.getState().equals(state)) 
			{
				placeList.add(tp);
			}
		}
		return placeList;
	}
}
