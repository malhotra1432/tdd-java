package com.tdd.fms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
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
            alice = new Passenger("alice123", "Alice", true, 10, 1000);
            bob = new Passenger("bob123", "Bob", false, 20, 2000);
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
            alice = new Passenger("alice123", "Alice", true, 10, 1000);
            bob = new Passenger("bob123", "Bob", false, 20, 2000);
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
            alice = new Passenger("alice123", "Alice", true, 10, 1000);
            bob = new Passenger("bob123", "Bob", false, 20, 2000);
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

    @DisplayName("Add a passenger only once to the flight")
    @Nested
    class SinglePassengerTest {
        private Flight premiumFlight;
        private Flight businessFlight;
        private Flight economicFlight;
        private Passenger alice;
        private Passenger bob;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("1");
            economicFlight = new EconomyFlight("2");
            premiumFlight = new PremiumFlight("3");
            alice = new Passenger("alice123", "Alice", true, 10, 1000);
            bob = new Passenger("bob123", "Bob", false, 20, 2000);
        }

        @Test
        void shouldNotAddSamePassengerTwiceToBusinessFlight() {

            businessFlight.addPassenger(bob);
            businessFlight.addPassenger(alice);

            var businessFlightBobCount = businessFlight.getPassengersList().stream()
                    .filter(passenger -> passenger.getBookingId().equals(bob.getBookingId()))
                    .count();

            var businessFlightAliceCount = businessFlight.getPassengersList().stream()
                    .filter(passenger -> passenger.getBookingId().equals(alice.getBookingId()))
                    .count();

            assertFalse(businessFlight.addPassenger(bob));
            assertFalse(businessFlight.addPassenger(bob));
            assertEquals(1, businessFlightBobCount);
            assertFalse(businessFlight.addPassenger(alice));
            assertEquals(1, businessFlightAliceCount);
            assertEquals(2, businessFlight.getPassengersList().size());
        }

        @Test
        void shouldNotAddSamePassengerTwiceToEconomicFlight() {

            economicFlight.addPassenger(bob);
            economicFlight.addPassenger(alice);

            var economicFlightBobCount = economicFlight.getPassengersList().stream()
                    .filter(passenger -> passenger.getBookingId().equals(bob.getBookingId()))
                    .count();

            var economicFlightAliceCount = economicFlight.getPassengersList().stream()
                    .filter(passenger -> passenger.getBookingId().equals(bob.getBookingId()))
                    .count();

            assertFalse(economicFlight.addPassenger(bob));
            assertFalse(economicFlight.addPassenger(bob));
            assertEquals(1, economicFlightBobCount);
            assertFalse(economicFlight.addPassenger(alice));
            assertEquals(1, economicFlightAliceCount);
            assertEquals(2, economicFlight.getPassengersList().size());
        }

        @Test
        void shouldNotAddSamePassengerTwiceToPremiumFlight() {

            premiumFlight.addPassenger(alice);

            var premiumFlightSinglePassengerCount = premiumFlight.getPassengersList().stream()
                    .filter(passenger -> passenger.getBookingId().equals(alice.getBookingId()))
                    .count();

            assertFalse(premiumFlight.addPassenger(alice));
            assertFalse(premiumFlight.addPassenger(alice));
            assertEquals(1, premiumFlightSinglePassengerCount);
            assertEquals(1, premiumFlight.getPassengersList().size());
        }
    }

    @DisplayName("Bonus point for passengers")
    @Nested
    class PassengerBonusPointsTest {
        private Passenger alice;
        private Passenger bob;

        @BeforeEach
        void setUp() {
            alice = new Passenger("alice123", "Alice", true, 10, 1000);
            bob = new Passenger("bob123", "Bob", false, 20, 2000);
        }

        @Test
        void shouldCalculateBonusPointsForNonVipPassenger() {
            bob.setBonusPoint(bob.calculatePassengerBonusPoints(bob));
            assertEquals(bob.getDistanceTravelled() / 20, bob.getBonusPoint());
        }

        @Test
        void shouldCalculateBonusPointsForVipPassenger() {
            alice.setBonusPoint(alice.calculatePassengerBonusPoints(alice));
            assertEquals(alice.getDistanceTravelled() / 10, alice.getBonusPoint());
        }
    }

}
