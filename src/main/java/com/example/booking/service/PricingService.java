package com.example.booking.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class PricingService {

    public double applyDiscount(double price, int seats, LocalTime showTime){

        double total = price * seats;

        // 50% discount on 3rd ticket
        if(seats >= 3){
            total -= price * 0.5;
        }

        // afternoon discount
        if(showTime.getHour() < 16){
            total *= 0.8;
        }

        return total;
    }
}
