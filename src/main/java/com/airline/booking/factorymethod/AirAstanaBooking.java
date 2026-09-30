package com.airline.booking.factorymethod;

public class AirAstanaBooking implements AirlineBooking {

    private final double totalPrice;

    public AirAstanaBooking(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String getAirline() {
        return "Air Astana";
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String getDescription() {
        return "Air Astana booking with standard service";
    }
}