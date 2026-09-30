package com.airline.booking.factorymethod;

public class ScatBooking implements AirlineBooking {

    private final double totalPrice;

    public ScatBooking(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String getAirline() {
        return "SCAT";
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String getDescription() {
        return "SCAT booking with flexible service options";
    }
}