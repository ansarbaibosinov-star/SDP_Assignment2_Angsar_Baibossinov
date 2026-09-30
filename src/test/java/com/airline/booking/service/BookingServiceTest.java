package com.airline.booking.service;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirAstanaFactory;
import com.airline.booking.abstractfactory.ScatFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    @Test
    void createsBookingProducts() {

        AirlineFactory factory = new AirAstanaFactory();

        BookingService service =
                new BookingService(factory);

        assertNotNull(service.createBookingProducts());
    }

    @Test
    void calculatesTotalPrice() {

        AirlineFactory factory = new AirAstanaFactory();

        BookingService service =
                new BookingService(factory);

        var products = service.createBookingProducts();

        double total = service.calculateTotalPrice(products);

        assertEquals(16000, total);
    }

    @Test
    void confirmsBooking() {

        AirlineFactory factory = new ScatFactory();

        BookingService service =
                new BookingService(factory);

        var products = service.createBookingProducts();

        String result = service.confirmBooking(products);

        assertTrue(result.contains("Booking confirmed"));
        assertTrue(result.contains("SCAT"));
    }

    @Test
    void nullBundleCannotBeCalculated() {

        AirlineFactory factory = new AirAstanaFactory();

        BookingService service =
                new BookingService(factory);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.calculateTotalPrice(null)
        );
    }

    @Test
    void nullBundleCannotBeConfirmed() {

        AirlineFactory factory = new AirAstanaFactory();

        BookingService service =
                new BookingService(factory);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.confirmBooking(null)
        );
    }
}