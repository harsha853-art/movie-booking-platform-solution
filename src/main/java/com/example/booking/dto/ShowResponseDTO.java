package com.example.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ShowResponseDTO {
    private Long theatreId;
    private LocalTime startTime;
    private double price;
}

