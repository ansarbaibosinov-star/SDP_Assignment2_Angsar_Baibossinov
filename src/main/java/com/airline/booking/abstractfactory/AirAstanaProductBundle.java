package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public class AirAstanaProductBundle implements AirlineProductBundle {

    private final Seat seat;
    private final Meal meal;
    private final Baggage baggage;

    AirAstanaProductBundle(
            Seat seat,
            Meal meal,
            Baggage baggage
    ) {
        this.seat = seat;
        this.meal = meal;
        this.baggage = baggage;
    }

    @Override
    public Seat getSeat() {
        return seat;
    }

    @Override
    public Meal getMeal() {
        return meal;
    }

    @Override
    public Baggage getBaggage() {
        return baggage;
    }

    @Override
    public String getAirline() {
        return "Air Astana";
    }

    @Override
    public double calculateProductsPrice() {
        return seat.getPrice()
                + meal.getPrice()
                + baggage.getPrice();
    }
}