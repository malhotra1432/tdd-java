package com.tdd.fms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FMSTest {

    @DisplayName("Given there is a Business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger alice;
        private Passenger bob;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("1");
            alice = new Passenger("Alice", true);
            bob = new Passenger("Bob", false);
        }

        @Test
        void shouldAddNonVipPassengerToBusinessFlight() {

            assertTrue(businessFlight.addPassenger(bob));
            assertEquals(1, businessFlight.getPassengersList().size());
        }

        @Test
        void shouldAddVipPassengerFromBusinessFlight() {
            assertTrue(businessFlight.addPassenger(alice));
            assertEquals(1, businessFlight.getPassengersList().size());
        }

        @Test
        void shouldNotRemoveVipPassengerFromBusinessFlight() {
            businessFlight.addPassenger(alice);

            assertFalse(businessFlight.removePassenger(alice));
            assertEquals(1, businessFlight.getPassengersList().size());

        }

        @Test
        void shouldRemoveNonVipPassengerFromBusinessFlight() {
            businessFlight.addPassenger(bob);

            assertFalse(businessFlight.removePassenger(bob));
            assertEquals(1, businessFlight.getPassengersList().size());
        }
    }

    @DisplayName("Given there is an Economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger alice;
        private Passenger bob;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            alice = new Passenger("Alice", true);
            bob = new Passenger("Bob", false);
        }

        @Test
        void shouldAddNonVipPassengerToEconomyFlight() {
            assertTrue(economyFlight.addPassenger(bob));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldAddVipPassengerFromEconomyFlight() {
            assertTrue(economyFlight.addPassenger(alice));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldNotRemoveVipPassengerFromEconomyFlight() {
            economyFlight.addPassenger(alice);

            assertFalse(economyFlight.removePassenger(alice));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

        @Test
        void shouldRemoveNonVipPassengerFromEconomyFlight() {
            economyFlight.addPassenger(bob);

            assertTrue(economyFlight.removePassenger(bob));
            assertEquals(0, economyFlight.getPassengersList().size());
        }
    }

    @DisplayName("Given there is a Premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger alice;
        private Passenger bob;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("1");
            alice = new Passenger("Alice", true);
            bob = new Passenger("Bob", false);
        }

        @Test
        void shouldAddVipPassengerToPremiumFlight() {
            assertTrue(premiumFlight.addPassenger(alice));
            assertEquals(1, premiumFlight.getPassengersList().size());
        }

        @Test
        void shouldNotAddNonVipPassengerToPremiumFlight() {
            assertFalse(premiumFlight.addPassenger(bob));
            assertEquals(0, premiumFlight.getPassengersList().size());
        }

        @Test
        void shouldRemoveVipPassengerFromPremiumFlight() {
            premiumFlight.getPassengersList().add(alice);
            assertTrue(premiumFlight.removePassenger(alice));
            assertEquals(0, premiumFlight.getPassengersList().size());
        }

        @Test
        void shouldRemoveNonVipPassengerFromPremiumFlight() {
            assertFalse(premiumFlight.addPassenger(bob));
            assertFalse(premiumFlight.removePassenger(bob));
            assertEquals(0, premiumFlight.getPassengersList().size());
        }

    }
}
