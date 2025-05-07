package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Theater;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.TheaterDTO;
import com.moviebooking.www.service.TheaterService;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@GetMapping
	public ResponseEntity<List<Theater>> getAllTheater() {
		return ResponseEntity.ok(theaterService.findAllTheaters());
	}

	@GetMapping("/{location}")
	public ResponseEntity<List<Theater>> findTheaterByLocation(@PathVariable String location) {
		return ResponseEntity.ok(theaterService.findTheaterByLocation(location));
	}

	// ADMIN API
	// ------------------------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Theater> addTheater(@RequestBody @Valid TheaterDTO theaterDTO) {
		return ResponseEntity.ok(theaterService.addTheater(theaterDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Theater> updateTheater(@PathVariable long id, @RequestBody @Valid TheaterDTO theaterDTO) {
		return ResponseEntity.ok(theaterService.updateTheater(id, theaterDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Theater> deleteTheater(long id) {
		theaterService.deleteTheater(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<Theater> deleteAllTheater() {
		theaterService.deleteAllTheater();
		return ResponseEntity.ok().build();
	}



}
