package com.htc.soapjdbc.service;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.htc.soapjdbc.resource.TouristPlace;

@WebService(endpointInterface="com.htc.soapjdbc.service.TouristService")
public class TouristServiceImpl	implements TouristService
{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public TouristPlace locateTouristPlace(String touristPlace) 
	{
		TouristPlace tp = null;
		String sql = "select placename,city,state,touristspotnames from tourist where placename = ?";
		tp =  jdbcTemplate.queryForObject(sql,
				new RowMapper<TouristPlace>() 
		{
			@Override
			public TouristPlace mapRow(ResultSet rs, int arg1) throws SQLException 
			{
				TouristPlace e = new TouristPlace();
				e.setPlaceName(rs.getString(1));
				e.setCity(rs.getString(2));
				e.setState(rs.getString(3));

				Array spotname = rs.getArray(4);							
				String[] str_spotname = (String[]) spotname.getArray();																					
				e.setTouristSpotNames(str_spotname);
				return e;		
			}
		}, 
		new Object[] {touristPlace}				
				);
		return tp;
	}

	@Override
	public List<TouristPlace> findTouristPlaces(String state) 
	{
		List<TouristPlace> tpList = null;
		tpList = jdbcTemplate.query("select placename, city, state ,touristspotnames from tourist where state = ?", 
				new RowMapper<TouristPlace>()
		{

			@Override
			public TouristPlace mapRow(ResultSet rs, int arg1) throws SQLException
			{
				TouristPlace e = new TouristPlace();
				e.setPlaceName(rs.getString(1));
				e.setCity(rs.getString(2));
				e.setState(rs.getString(3));

				Array spotname = rs.getArray(4);							
				String[] str_spotname = (String[]) spotname.getArray();	
				e.setTouristSpotNames(str_spotname);
				return e;
			}
		},
				new Object[] {state}
				);
		return tpList;
	}
}
