package com.airline.booking.factorymethod;

public class ScatBookingCreator extends BookingCreator {

    @Override
    protected AirlineBooking createBooking(double totalPrice) {
        return new ScatBooking(totalPrice);
    }
}