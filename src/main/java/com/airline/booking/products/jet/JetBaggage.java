package com.airline.booking.products.jet;

import com.airline.booking.products.Baggage;

public class JetBaggage implements Baggage {

    private final int weight;
    private final double price;

    public JetBaggage(int weight, double price) {
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


}