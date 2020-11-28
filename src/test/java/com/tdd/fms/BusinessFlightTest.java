package com.tdd.fms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessFlightTest {

    @Test
    void shouldAddNonVipPassengerToBusinessFlight() {
        Flight businessFlight = new BusinessFlight("1");
        Passenger passenger = new Passenger("Alice", false);

        assertTrue(businessFlight.addPassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }

    @Test
    void shouldAddVipPassengerFromBusinessFlight() {
        Flight businessFlight = new BusinessFlight("1");
        Passenger passenger = new Passenger("Marley", true);

        assertTrue(businessFlight.addPassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }

    @Test
    void shouldNotRemoveVipPassengerFromBusinessFlight() {
        Flight businessFlight = new BusinessFlight("1");
        Passenger passenger = new Passenger("Bob", true);

        businessFlight.addPassenger(passenger);

        assertFalse(businessFlight.removePassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());

    }

    @Test
    void shouldRemoveNonVipPassengerFromBusinessFlight() {
        Flight businessFlight = new BusinessFlight("1");
        Passenger passenger = new Passenger("Marley", false);

        businessFlight.addPassenger(passenger);

        assertFalse(businessFlight.removePassenger(passenger));
        assertEquals(1, businessFlight.getPassengersList().size());
    }
}
