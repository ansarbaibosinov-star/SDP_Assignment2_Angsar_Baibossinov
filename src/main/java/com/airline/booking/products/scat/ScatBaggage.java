package com.airline.booking.products.scat;

import com.airline.booking.products.Baggage;

public class ScatBaggage implements Baggage {

    private final int weight;
    private final double price;

    public ScatBaggage(int weight, double price) {
        if (weight <= 0) {
            throw new IllegalArgumentException(
                    "Baggage weight must be positive"
            );
        }

        this.weight = weight;
        this.price = price;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getAirline() {
        return "SCAT";
    }
}