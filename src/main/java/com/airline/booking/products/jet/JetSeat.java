package com.airline.booking.products.jet;

import com.airline.booking.products.Seat;

public class JetSeat implements Seat {

    private final String seatNumber;
    private final String classType;
    private final double price;

    public JetSeat(
            String seatNumber,
            String classType,
            double price
    ) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.price = price;
    }

    @Override
    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String getClassType() {
        return classType;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getAirline() {
        return "Jet";
    }
}