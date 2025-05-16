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
    public List<Movie> findAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findMovieByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenre(genre);
        if (movies.isEmpty()) {
            throw new RuntimeException("No such movie found for genre " + genre);
        }
        return movies;
    }

    @Override
    public List<Movie> findMovieByLanguage(String language) {
        List<Movie> movieListBox = movieRepository.findByLanguage(language);
        if (movieListBox.isEmpty()) {
            throw new RuntimeException("No such movie found for language " + language);
        }
        return movieListBox;
    }

    @Override
    public List<Movie> findMovieByTitle(String title) {
        List<Movie> movieListBox = movieRepository.findByTitle(title);
        if (movieListBox.isEmpty()) {
            throw new RuntimeException("No such movie found for title " + title);
        }
        return movieListBox;
    }

    @Override
    public Movie addMovie(MovieDTO movieDTO) {

        Movie movie = new Movie();

        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());

        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such show found for id " + id));

        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());

        return movieRepository.save(movie);

    }

    @Override
    public void deleteMovies(long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void deleteAllMovie() {
        movieRepository.deleteAll();
    }

}
