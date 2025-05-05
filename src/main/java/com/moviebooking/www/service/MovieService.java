package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.entity.Movie;

public interface MovieService {
	List<Movie> getAllMovie();
	List<Movie> getMovieByGenre(String genre);
	List<Movie> getMovieByLanguage(String language);
	List<Movie> getMovieByTitle(String title);

	
	Movie addMovie(MovieDTO movieDTO);
	Movie updateMovie(long id, MovieDTO movieDTO);
	void deleteMovies(long id);
	void deletAllMovie();
	
}
