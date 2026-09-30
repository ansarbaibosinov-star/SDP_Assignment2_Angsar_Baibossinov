package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;
import com.airline.booking.products.fly.FlyBaggage;
import com.airline.booking.products.fly.FlyMeal;
import com.airline.booking.products.fly.FlySeat;

public class FlyFactory implements AirlineFactory {

    @Override
    public Seat createSeat() {
        return new FlySeat("7B", "Economy", 2800);
    }

    @Override
    public Meal createMeal() {
        return new FlyMeal("Standard", 4800);
    }

    @Override
    public Baggage createBaggage() {
        return new FlyBaggage(20, 7500);
    }

    @Override
    public AirlineProductBundle createProductBundle() {
        return new FlyProductBundle(
                createSeat(),
                createMeal(),
                createBaggage()
        );
    }
}