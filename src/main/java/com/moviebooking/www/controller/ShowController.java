package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Show;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.service.ShowService;

import java.util.List;

@RestController
@RequestMapping("/api/show")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class ShowController {

	@Autowired
	ShowService showService;

	@GetMapping
	public ResponseEntity<List<Show>> getAllShow() {
		return ResponseEntity.ok(showService.getAllShow());
	}

//	@GetMapping("/movie/{movie}")
//	public ResponseEntity<List<Show>> getShowByMovie(@PathVariable  String movie) {
//		return ResponseEntity.ok(showService.getShowByMovies(movie));
//	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<List<Show>> getShowByMovieId(@PathVariable  long id) {
		return ResponseEntity.ok(showService.getShowByMovieById(id));
	}

	@GetMapping("/theater/{theaterId}")
	public ResponseEntity<List<Show>> getShowByTheater(@PathVariable long theaterId) {
		return ResponseEntity.ok(showService.getShowByTheater(theaterId));
	}

	// ADMIN APIS
	// -----------------------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Show> addShow(@RequestBody @Valid ShowDTO showDTO) {
		return ResponseEntity.ok(showService.addShow(showDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Show> updateShow(@PathVariable long id, @RequestBody @Valid ShowDTO showDTO) {
		return ResponseEntity.ok(showService.updateShow(id, showDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Show> deleteShow(@PathVariable long id) {
		showService.deleteShow(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<List<Show>> deleteAllShow() {
		showService.deleteAllShow();
		return ResponseEntity.ok().build();
	}
}
