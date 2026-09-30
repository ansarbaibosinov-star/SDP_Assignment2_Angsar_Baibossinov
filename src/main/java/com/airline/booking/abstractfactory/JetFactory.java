package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;
import com.airline.booking.products.jet.JetBaggage;
import com.airline.booking.products.jet.JetMeal;
import com.airline.booking.products.jet.JetSeat;

public class JetFactory implements AirlineFactory {

    @Override
    public Seat createSeat() {
        return new JetSeat("4A", "Business", 3500);
    }

    @Override
    public Meal createMeal() {
        return new JetMeal("Premium", 5500);
    }

    @Override
    public Baggage createBaggage() {
        return new JetBaggage(20, 9000);
    }

    @Override
    public AirlineProductBundle createProductBundle() {
        return new JetProductBundle(
                createSeat(),
                createMeal(),
                createBaggage()
        );
    }
}