package com.tdd.fms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FmsApplicationTests {

	@Test
	void testFMS() {
		Flight economyFlight = new EconomyFlight("1");
		Flight businessFlight = new BusinessFlight("2");

		Passenger alice = new Passenger("Alice",true);
		Passenger bob = new Passenger("Bob",false);

		assertTrue(economyFlight.addPassenger(alice));
		assertFalse(economyFlight.removePassenger(alice));
		assertTrue(businessFlight.addPassenger(alice));
		assertFalse(businessFlight.removePassenger(alice));

		assertTrue(economyFlight.addPassenger(bob));
		assertTrue(economyFlight.removePassenger(bob));
		assertTrue(businessFlight.addPassenger(bob));
		assertFalse(businessFlight.removePassenger(bob));
	}


}
