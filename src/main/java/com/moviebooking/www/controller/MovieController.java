package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.www.dto.MovieDTO;
import com.moviebooking.www.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAllMovie() {
		return ResponseEntity.ok(movieService.getAllMovie());
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@RequestParam String genre) {
		return ResponseEntity.ok(movieService.getMovieByGenre(genre));
	}

	@GetMapping("/{language}")
	public ResponseEntity<List<Movie>> getMovieByLanguage(@RequestParam String language) {
		return ResponseEntity.ok(movieService.getMovieByLanguage(language));
	}

	@GetMapping("/{title}")
	public ResponseEntity<List<Movie>> getMovieByTitle(@RequestParam String title) {
		return ResponseEntity.ok(movieService.getMovieByTitle(title));
	}

	// ADMIN APIS
	// -----------------------------------------------------------------------------------------
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody @Valid MovieDTO movieDTO) {
		return ResponseEntity.ok(movieService.addMovie(movieDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movie> editMovie(@PathVariable long id, @RequestBody @Valid MovieDTO movieDTO) {
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
