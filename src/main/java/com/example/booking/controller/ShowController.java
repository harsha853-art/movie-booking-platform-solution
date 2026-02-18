package com.example.booking.controller;

import com.example.booking.dto.ShowResponseDTO;
import com.example.booking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public List<ShowResponseDTO> browse(
            @RequestParam Long movieId,
            @RequestParam String date){

        return showService.browseShows(
                movieId,
                LocalDate.parse(date));
    }
}

