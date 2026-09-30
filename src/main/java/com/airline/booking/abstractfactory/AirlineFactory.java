package com.airline.booking.abstractfactory;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public interface AirlineFactory {

    Seat createSeat();

    Meal createMeal();

    Baggage createBaggage();
}
//Любая авиакомпания должна уметь создать Seat, Meal и Baggage