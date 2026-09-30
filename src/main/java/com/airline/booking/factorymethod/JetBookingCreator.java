package com.airline.booking.factorymethod;

public class JetBookingCreator extends BookingCreator {

    @Override
    protected AirlineBooking createBooking(double totalPrice) {
        return new JetBooking(totalPrice);
    }
}