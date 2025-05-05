package com.moviebooking.www.controller;

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

import com.moviebooking.www.dto.TheaterDTO;
import com.moviebooking.www.service.TheaterService;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@GetMapping
	public ResponseEntity<?> getAllTheater() {
		return ResponseEntity.ok(theaterService.findAllTheaters());
	}

	@GetMapping("/bylocation")
	public ResponseEntity<?> getTheaterByLocation(@RequestParam String location) {
		return ResponseEntity.ok(theaterService.findTheaterByLocation(location));
	}

	// ADMIN API
	// ------------------------------------------------------------------------------------------
	@PostMapping
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addTheater(@RequestBody TheaterDTO theaterDTO) {
		return ResponseEntity.ok(theaterService.addTheater(theaterDTO));
	}

	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTheater(@PathVariable long id, TheaterDTO theaterDTO) {
		return ResponseEntity.ok(theaterService.updateTheater(id, theaterDTO));
	}

	@DeleteMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTheater(long id) {
		theaterService.deleteTheater(id);
		return ResponseEntity.ok().build();
	}

}
