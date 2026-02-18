package com.example.booking.service;

import com.example.booking.model.Booking;
import com.example.booking.model.Show;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.ShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final PricingService pricingService;

    @Transactional
    public Booking book(Long showId, int seats){

        Show show = showRepository.findById(showId)
                .orElseThrow();

        double total = pricingService.applyDiscount(
                show.getPrice(),
                seats,
                show.getStartTime()
        );

        Booking booking = new Booking();
        booking.setShowId(showId);
        booking.setSeats(seats);
        booking.setTotalPrice(total);

        return bookingRepository.save(booking);
    }
}
