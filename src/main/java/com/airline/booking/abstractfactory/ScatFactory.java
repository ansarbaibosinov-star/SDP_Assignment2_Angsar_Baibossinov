package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;
import com.airline.booking.products.scat.ScatBaggage;
import com.airline.booking.products.scat.ScatMeal;
import com.airline.booking.products.scat.ScatSeat;

public class ScatFactory implements AirlineFactory {

    @Override
    public Seat createSeat() {
        return new ScatSeat("18C", "Economy", 2500);
    }

    @Override
    public Meal createMeal() {
        return new ScatMeal("Standard", 4500);
    }

    @Override
    public Baggage createBaggage() {
        return new ScatBaggage(20, 7000);
    }
}
