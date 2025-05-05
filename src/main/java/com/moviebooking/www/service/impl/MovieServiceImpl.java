package com.moviebooking.www.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.entity.Movie;
import com.moviebooking.www.repository.MovieRepository;
import com.moviebooking.www.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovie() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> getMovieByGenre(String genre) {
		Optional<List<Movie>> movieListBox = movieRepository.findByGenre(genre);
		if (movieListBox.isPresent()) {
			return movieListBox.get();
		} else {
			throw new RuntimeException("No such movie found for genre " + genre);
		}
	}

	@Override
	public List<Movie> getMovieByLanguage(String language) {
		Optional<List<Movie>> movieListBox = movieRepository.findByLanguage(language);
		if (movieListBox.isPresent()) {
			return movieListBox.get();
		} else {
			throw new RuntimeException("No such movie found for language " + language);
		}
	}

	@Override
	public List<Movie> getMovieByTitle(String title) {
		Optional<List<Movie>> movieListBox = movieRepository.findByTitle(title);
		if (movieListBox.isPresent()) {
			return movieListBox.get();
		} else {
			throw new RuntimeException("No such movie found for title " + title);
		}
	}

	@Override
	public Movie addMovie(MovieDTO movieDTO) {
		Movie movie = new Movie();
		movie.setTitle(movieDTO.getTitle());
		movie.setDescription(movieDTO.getDescription());
		movie.setGenre(movieDTO.getGenre());
		movie.setLanguage(movieDTO.getLanguage());
		movie.setDuration(movieDTO.getDuration());
		movie.setReleaseDate(movieDTO.getReleaseDate());
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(long id, MovieDTO movieDTO) {
		Optional<Movie> movieBox = movieRepository.findById(id);
		if (movieBox.isPresent()) {
			Movie movie = movieBox.get();
			movie.setTitle(movieDTO.getTitle());
			movie.setDescription(movieDTO.getDescription());
			movie.setGenre(movieDTO.getGenre());
			movie.setLanguage(movieDTO.getLanguage());
			movie.setDuration(movieDTO.getDuration());
			movie.setReleaseDate(movieDTO.getReleaseDate());
			return movieRepository.save(movie);
		} else {
			throw new RuntimeException("No such movie found for id " + id);
		}
	}

	@Override
	public void deleteMovies(long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public void deletAllMovie() {
		movieRepository.deleteAll();
	}

}
