package com.moviebooking.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.Movie;
import com.moviebooking.www.entity.Show;
import com.moviebooking.www.entity.Theater;
import com.moviebooking.www.repository.MovieRepository;
import com.moviebooking.www.repository.ShowRepository;
import com.moviebooking.www.repository.TheaterRepository;
import com.moviebooking.www.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public List<Show> findAllShow() {
        return showRepository.findAll();
    }

    @Override
    public Show findById(long id){
        return showRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No such show found for this ID " + id));
    }

    @Override
    public List<Show> findByMovieId(long id) {
        return showRepository.findByMovieId(id);
    }

    @Override
    public List<Show> findByTheaterId(long id) {
        return showRepository.findByTheaterId(id);
    }

    @Override
    public Show addShow(ShowDTO showDTO) {

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()-> new RuntimeException("No such movie found for this ID " + showDTO.getMovieId()));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()-> new RuntimeException("No such theater found for this ID " + showDTO.getTheaterId()));

        Show show = new Show();

        show.setMovie(movie);
        show.setTheater(theater);
        show.setShowTime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice());

        return showRepository.save(show);
    }

    @Override
    public Show updateShow(long id, ShowDTO showDTO) {

        Show oldShow = showRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Show not found for ID: "+ id));

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()-> new RuntimeException("No such movie found for this ID " + showDTO.getMovieId()));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()-> new RuntimeException("No such theater found for this ID " + showDTO.getTheaterId()));


        oldShow.setShowTime(showDTO.getShowTime());
        oldShow.setPrice(showDTO.getPrice());
        oldShow.setMovie(movie);
        oldShow.setTheater(theater);

        return showRepository.save(oldShow);
    }

    @Override
    public void deleteShow(long id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such show found for this ID " + id));

        List<Booking> bookings = show.getBookings();
        if (bookings.isEmpty()) {
            showRepository.delete(show);
        } else {
            throw new RuntimeException("Cannot delete show as there is an active booking");
        }

    }

    @Override
    public void deleteAllShow() {
        List<Show> shows = showRepository.findAll();
        for (Show show : shows) {
            List<Booking> bookings = show.getBookings();
            if (bookings.isEmpty()) {
                showRepository.delete(show);
            }
        }
    }

}
