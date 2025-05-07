package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/all")
	public ResponseEntity<List<Movie>> findAllMovie() {
		return ResponseEntity.ok(movieService.getAllMovie());
	}

	@GetMapping("/genre/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok(movieService.getMovieByGenre(genre));
	}

	@GetMapping("/language/{language}")
	public ResponseEntity<List<Movie>> getMovieByLanguage(@PathVariable String language) {
		return ResponseEntity.ok(movieService.getMovieByLanguage(language));
	}

	@GetMapping("/name/{title}")
	public ResponseEntity<List<Movie>> getMovieByTitle(@PathVariable String title) {
		return ResponseEntity.ok(movieService.getMovieByTitle(title));
	}

	// ADMIN APIS
	// -----------------------------------------------------------------------------------------
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody @Valid MovieDTO movieDTO) {
		return ResponseEntity.ok(movieService.addMovie(movieDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody @Valid MovieDTO movieDTO) {
		return ResponseEntity.ok(movieService.updateMovie(id, movieDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable long id) {
		movieService.deleteMovies(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<List<Movie>> deleteAllMovie() {
		movieService.deletAllMovie();
		return ResponseEntity.ok().build();
	}

}
