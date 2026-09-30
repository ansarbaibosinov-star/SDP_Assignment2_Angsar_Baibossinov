package com.airline.booking.factory;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.FactoryProvider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryProviderTest {

    @Test
    void selectsAirAstanaFactory() {

        AirlineFactory factory =
                FactoryProvider.getFactory("airastana");

        assertEquals(
                "Air Astana",
                factory.createProductBundle().getAirline()
        );
    }

    @Test
    void selectsScatFactory() {

        AirlineFactory factory =
                FactoryProvider.getFactory("scat");

        assertEquals(
                "SCAT",
                factory.createProductBundle().getAirline()
        );
    }

    @Test
    void selectsJetFactory() {

        AirlineFactory factory =
                FactoryProvider.getFactory("jet");

        assertEquals(
                "Jet",
                factory.createProductBundle().getAirline()
        );
    }

    @Test
    void selectsFlyFactory() {

        AirlineFactory factory =
                FactoryProvider.getFactory("fly");

        assertEquals(
                "Fly",
                factory.createProductBundle().getAirline()
        );
    }

    @Test
    void unknownAirlineThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> FactoryProvider.getFactory("unknown")
        );
    }
}