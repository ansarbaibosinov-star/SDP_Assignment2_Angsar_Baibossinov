package com.airline.booking.products.jet;

import com.airline.booking.products.Meal;

public class JetMeal implements Meal {

    private final String mealType;
    private final double price;

    public JetMeal(String mealType, double price) {
        this.mealType = mealType;
        this.price = price;
    }

    @Override
    public String getMealType() {
        return mealType;
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