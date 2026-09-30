package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;
import com.airline.booking.products.airastana.AirAstanaBaggage;
import com.airline.booking.products.airastana.AirAstanaMeal;
import com.airline.booking.products.airastana.AirAstanaSeat;

public class AirAstanaFactory implements AirlineFactory {

    @Override
    public Seat createSeat() {
        return new AirAstanaSeat("12A", "Economy", 3000);
    }

    @Override
    public Meal createMeal() {
        return new AirAstanaMeal("Standard", 5000);
    }

    @Override
    public Baggage createBaggage() {
        return new AirAstanaBaggage(20, 8000);
    }

    @Override
    public AirlineProductBundle createProductBundle() {
        return new AirAstanaProductBundle(
                createSeat(),
                createMeal(),
                createBaggage()
        );
    }
}