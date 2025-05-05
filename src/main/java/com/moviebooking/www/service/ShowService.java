package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.entity.Show;

public interface ShowService {
	List<Show> getAllShow();
	
	
	List<Show> getShowByMovies(String movie);
	List<Show> getShowByTheater(String theater);
	Show addShow(ShowDTO showDTO);
	Show updateShow(long id, ShowDTO showDTO);
	void deleteShow(long id);
	void deleteAllShow();
}
