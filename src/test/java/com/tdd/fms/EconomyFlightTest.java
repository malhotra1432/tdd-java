package com.tdd.fms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EconomyFlightTest {

    @Test
    void shouldAddNonVipPassengerToEconomyFlight() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger passenger = new Passenger("Alice", false);

        assertTrue(economyFlight.addPassenger(passenger));
        assertEquals(1, economyFlight.getPassengersList().size());
    }

    @Test
    void shouldAddVipPassengerFromEconomyFlight() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger passenger = new Passenger("Marley", true);

        assertTrue(economyFlight.addPassenger(passenger));
        assertEquals(1, economyFlight.getPassengersList().size());
    }

    @Test
    void shouldNotRemoveVipPassengerFromEconomyFlight() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger passenger = new Passenger("Bob", true);

        economyFlight.addPassenger(passenger);

        assertFalse(economyFlight.removePassenger(passenger));
        assertEquals(1, economyFlight.getPassengersList().size());
    }

    @Test
    void shouldRemoveNonVipPassengerFromEconomyFlight() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger passenger = new Passenger("Marley", false);

        economyFlight.addPassenger(passenger);

        assertTrue(economyFlight.removePassenger(passenger));
        assertEquals(0, economyFlight.getPassengersList().size());
    }
}
