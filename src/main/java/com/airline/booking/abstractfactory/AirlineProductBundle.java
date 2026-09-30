package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public interface AirlineProductBundle {

    Seat getSeat();

    Meal getMeal();

    Baggage getBaggage();

    String getAirline();

    double calculateProductsPrice();
}