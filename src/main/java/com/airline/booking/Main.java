package com.airline.booking;

import com.airline.booking.factorymethod.AirAstanaBookingCreator;
import com.airline.booking.factorymethod.AirlineBooking;
import com.airline.booking.factorymethod.BookingCreator;
import com.airline.booking.factorymethod.JetBookingCreator;
import com.airline.booking.factorymethod.ScatBookingCreator;

public class Main {

    public static void main(String[] args) {

        BookingCreator airAstanaCreator =
                new AirAstanaBookingCreator();

        BookingCreator scatCreator =
                new ScatBookingCreator();

        BookingCreator jetCreator =
                new JetBookingCreator();

        AirlineBooking airAstanaBooking =
                airAstanaCreator.processBooking(50000, 5000);

        AirlineBooking scatBooking =
                scatCreator.processBooking(45000, 4000);

        AirlineBooking jetBooking =
                jetCreator.processBooking(60000, 7000);

        System.out.println();
        System.out.println(airAstanaBooking.getDescription());
        System.out.println(scatBooking.getDescription());
        System.out.println(jetBooking.getDescription());
    }
}