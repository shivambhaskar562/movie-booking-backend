package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.entity.Show;

public interface ShowService {
	List<Show> findAllShow();
	List<Show> findByMovieId(long movieId);
	List<Show> findByTheaterId(long theaterId);
	Show addShow(ShowDTO showDTO);
	Show updateShow(long id, ShowDTO showShow);
	void deleteShow(long id);
	void deleteAllShow();
}
