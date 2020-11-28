package com.tdd.fms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessFlightTest {
    private Flight businessFlight;

    @BeforeEach
    void setUp(){
        businessFlight = new BusinessFlight("1");
    }

    @Test
    void shouldAddNonVipPassengerToBusinessFlight() {
        Passenger passenger = new Passenger("Alice", false);

        assertTrue(businessFlight.addPassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }

    @Test
    void shouldAddVipPassengerFromBusinessFlight() {
        Passenger passenger = new Passenger("Marley", true);

        assertTrue(businessFlight.addPassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }

    @Test
    void shouldNotRemoveVipPassengerFromBusinessFlight() {
        Passenger passenger = new Passenger("Bob", true);

        businessFlight.addPassenger(passenger);

        assertFalse(businessFlight.removePassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());

    }

    @Test
    void shouldRemoveNonVipPassengerFromBusinessFlight() {
        Passenger passenger = new Passenger("Marley", false);

        businessFlight.addPassenger(passenger);

        assertFalse(businessFlight.removePassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }
}
