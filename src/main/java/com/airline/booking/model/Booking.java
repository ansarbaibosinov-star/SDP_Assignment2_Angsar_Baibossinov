package com.airline.booking.model;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public class Booking {

    private final String bookingNumber;
    private final Passenger passenger;
    private final Flight flight;

    private final Seat seat;
    private final Meal meal;
    private final Baggage baggage;

    public Booking(
            String bookingNumber,
            Passenger passenger,
            Flight flight,
            Seat seat,
            Meal meal,
            Baggage baggage
    ) {
        this.bookingNumber = bookingNumber;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.meal = meal;
        this.baggage = baggage;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public Meal getMeal() {
        return meal;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public double calculateTotalPrice() {
        return flight.getBasePrice()
                + seat.getPrice()
                + meal.getPrice()
                + baggage.getPrice();
    }
}