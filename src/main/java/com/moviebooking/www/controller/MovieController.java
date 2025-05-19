package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Movie;
import com.moviebooking.www.response.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = { "http://localhost:3000",
"http://127.0.0.1:3000" }, allowedHeaders = "*", allowCredentials = "true")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
        List<Movie> movies = movieService.findAllMovie();

        ResponseStructure<List<Movie>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("All movies");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movies);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<ResponseStructure<List<Movie>>> getMovieByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.findMovieByGenre(genre);

        ResponseStructure<List<Movie>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Movie By Genre");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movies);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<ResponseStructure<List<Movie>>> getMovieByLanguage(@PathVariable String language) {
        List<Movie> movies = movieService.findMovieByLanguage(language);

        ResponseStructure<List<Movie>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Movie By Language");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movies);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/name/{title}")
    public ResponseEntity<ResponseStructure<List<Movie>>> getMovieByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findMovieByTitle(title);

        ResponseStructure<List<Movie>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Movie By Title");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movies);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    // Admin access
    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<Movie>> addMovie(@RequestBody @Valid MovieDTO movieDTO) {
        Movie movie = movieService.addMovie(movieDTO);

        ResponseStructure<Movie> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Movie added successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movie);
        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

    }

    // Admin access
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Movie>> updateMovie(@PathVariable long id, @RequestBody @Valid MovieDTO movieDTO) {
        Movie movie = movieService.updateMovie(id, movieDTO);

        ResponseStructure<Movie> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Movie details updated");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(movie);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    // Admin access
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<?>> deleteMovie(@PathVariable long id) {
        movieService.deleteMovies(id);

        ResponseStructure<?> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Movie Deleted");
        responseStructure.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    // Admin access
    @DeleteMapping
    public ResponseEntity<ResponseStructure<?>> deleteAllMovie() {
        movieService.deleteAllMovie();

        ResponseStructure<?> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("All movies without bookings have been deleted");
        responseStructure.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}
