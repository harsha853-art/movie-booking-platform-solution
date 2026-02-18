package com.example.booking.repository;

import com.example.booking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {

    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate date);
}

