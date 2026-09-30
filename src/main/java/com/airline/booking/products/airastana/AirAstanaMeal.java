package com.airline.booking.products.airastana;

import com.airline.booking.products.Meal;

public class AirAstanaMeal implements Meal {

    private final String mealType;
    private final double price;

    public AirAstanaMeal(String mealType, double price) {
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


}