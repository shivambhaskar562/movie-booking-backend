package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.TheaterDTO;
import com.moviebooking.www.entity.Theater;

public interface TheaterService {
	
	Theater addTheater(TheaterDTO theaterDTO);
	Theater updateTheater(long id, TheaterDTO theaterDTO);
	void deleteTheater(long id);
	void deleteAllTheater();

	
	List<Theater> findAllTheaters();
	List<Theater> findTheaterByLocation(String location);
	

}
