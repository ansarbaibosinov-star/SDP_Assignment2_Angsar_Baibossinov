package com.airline.booking.factorymethod;

public class JetBooking implements AirlineBooking {

    private final double totalPrice;

    public JetBooking(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String getAirline() {
        return "Jet";
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String getDescription() {
        return "Jet booking with premium service";
    }
}