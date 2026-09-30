package com.airline.booking.products.fly;

import com.airline.booking.products.Meal;

public class FlyMeal implements Meal {

    private final String mealType;
    private final double price;

    public FlyMeal(String mealType, double price) {
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