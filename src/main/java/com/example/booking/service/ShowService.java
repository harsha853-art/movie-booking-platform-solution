package com.example.booking.service;

import com.example.booking.dto.ShowResponseDTO;
import com.example.booking.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public List<ShowResponseDTO> browseShows(Long movieId, LocalDate date){

        return showRepository
                .findByMovieIdAndShowDate(movieId,date)
                .stream()
                .map(s -> new ShowResponseDTO(
                        s.getTheatreId(),
                        s.getStartTime(),
                        s.getPrice()))
                .toList();
    }
}

