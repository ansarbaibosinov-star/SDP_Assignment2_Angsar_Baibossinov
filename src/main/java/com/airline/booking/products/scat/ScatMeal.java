package com.airline.booking.products.scat;

import com.airline.booking.products.Meal;

public class ScatMeal implements Meal {

    private final String mealType;
    private final double price;

    public ScatMeal(String mealType, double price) {
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
        return "SCAT";
    }
}