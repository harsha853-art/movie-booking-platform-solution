package com.example.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Show {
    @Id
    @GeneratedValue
    private Long id;

    private Long movieId;
    private Long theatreId;

    private LocalDate showDate;
    private LocalTime startTime;

    private double price;
}
