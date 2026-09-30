package com.airline.booking.factorymethod;

public class AirAstanaBookingCreator extends BookingCreator {

    @Override
    protected AirlineBooking createBooking(double totalPrice) {
        return new AirAstanaBooking(totalPrice);
    }
}