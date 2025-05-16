package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.entity.Movie;

public interface MovieService {
	List<Movie> findAllMovie();
	List<Movie> findMovieByGenre(String genre);
	List<Movie> findMovieByLanguage(String language);
	List<Movie> findMovieByTitle(String title);

	
	Movie addMovie(MovieDTO movieDTO);
	Movie updateMovie(long id, MovieDTO movieDTO);
	void deleteMovies(long id);
	void deleteAllMovie();
	
}
