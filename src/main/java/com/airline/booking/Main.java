package com.airline.booking;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirAstanaFactory;
import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public class Main {

    public static void main(String[] args) {

        AirlineFactory factory = new AirAstanaFactory();

        Seat seat = factory.createSeat();
        Meal meal = factory.createMeal();
        Baggage baggage = factory.createBaggage();

        System.out.println("Airline: " + seat.getAirline());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Meal: " + meal.getMealType());
        System.out.println("Baggage: " + baggage.getWeight() + " kg");

        System.out.println();

        double total = seat.getPrice()
                + meal.getPrice()
                + baggage.getPrice();

        System.out.println("Products total: " + total);
    }
}