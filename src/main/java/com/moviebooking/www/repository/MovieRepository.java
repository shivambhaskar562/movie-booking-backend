package com.moviebooking.www.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.www.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByGenre(String genre);
	List<Movie> findByLanguage(String language);
	List<Movie> findByTitle(String title);
}
