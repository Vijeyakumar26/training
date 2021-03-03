package com.htc.springrest.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.htc.springrest.resource.TouristPlace;

@Repository
public class TouristDAOImpl implements TouristDAO{

	@Autowired //by type
	JdbcTemplate jdbcTemplate;

	@Override
	public TouristPlace getTouristPlace(String placeName) 
	{
		TouristPlace tp = null;
		String sql = "select placename, city, state,touristSpotNames from tourist where placename = ?";
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
		new Object[] {placeName});
		return tp;
	}

	@Override
	public List<TouristPlace> getAllTouristPlaces(String state) 
	{
		List<TouristPlace> tpList = null;

		tpList = jdbcTemplate.query("select placename, city, state ,touristSpotNames from tourist where state = ?", 
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

	@Override
	public boolean addTouristPlace(TouristPlace place) {
		//		touristPlaces.add(place); //in Memory adding

		int result = jdbcTemplate.update("insert into tourist values(?,?,?,?)", place.getPlaceName(), place.getCity(), place.getState(), place.getTouristSpotNames());
		if(result > 0) 
			return true;
		return false;
	}

	@Override
	public boolean updateTouristPlace(String placeName, TouristPlace tp) 
	{
		int result = jdbcTemplate.update("update tourist set city =?,state=? where placename= ?", tp.getCity(),tp.getState(), placeName );
	 	if(result>0) 
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteTouristPlace(String placeName) 
	{
	 	int result = jdbcTemplate.update("delete from tourist where placename= ?", placeName);
		if(result > 0) 
			return true;
		else
			return false;
	}
}
