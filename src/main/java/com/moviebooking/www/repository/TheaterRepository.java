package com.moviebooking.www.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.www.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long>{
	Optional<List<Theater>> findByTheaterLocation(String theaterLocation);
	
}
