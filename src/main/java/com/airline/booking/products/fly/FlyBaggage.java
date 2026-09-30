package com.airline.booking.products.fly;

import com.airline.booking.products.Baggage;

public class FlyBaggage implements Baggage {

    private final int weight;
    private final double price;

    public FlyBaggage(int weight, double price) {
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