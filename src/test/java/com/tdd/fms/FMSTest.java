package com.tdd.fms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FMSTest {

    @Nested
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

    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;

        @BeforeEach
        void setUp(){
            economyFlight = new EconomyFlight("1");
        }

        @Test
        void shouldAddNonVipPassengerToEconomyFlight() {
            Passenger passenger = new Passenger("Alice", false);

            assertTrue(economyFlight.addPassenger(passenger));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldAddVipPassengerFromEconomyFlight() {
            Passenger passenger = new Passenger("Marley", true);

            assertTrue(economyFlight.addPassenger(passenger));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldNotRemoveVipPassengerFromEconomyFlight() {
            Passenger passenger = new Passenger("Bob", true);

            economyFlight.addPassenger(passenger);

            assertFalse(economyFlight.removePassenger(passenger));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldRemoveNonVipPassengerFromEconomyFlight() {
            Passenger passenger = new Passenger("Marley", false);

            economyFlight.addPassenger(passenger);

            assertTrue(economyFlight.removePassenger(passenger));
            assertEquals(0, economyFlight.getPassengersList().size());
        }
    }
}
