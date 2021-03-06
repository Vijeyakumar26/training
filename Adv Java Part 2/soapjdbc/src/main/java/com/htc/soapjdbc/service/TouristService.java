package com.htc.soapjdbc.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.htc.soapjdbc.resource.TouristPlace;

@WebService
public interface TouristService 
{
	@WebMethod(operationName="getTouristPlaceDetails")
	public @WebResult(name="touristPlace") TouristPlace locateTouristPlace(@WebParam(name="placeName") String touristPlace);
	
	@WebMethod(operationName ="getAllTouristPlaces")
	public @WebResult(name="placeList") List<TouristPlace> findTouristPlaces(@WebParam(name="state") String state);
}
