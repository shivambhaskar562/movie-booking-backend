package com.moviebooking.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebooking.www.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long>{
	@Query("SELECT t FROM Theater t WHERE t.theaterLocation = :theaterLocation")
	List<Theater> findByTheaterLocation(String theaterLocation);
	
}
