package com.tdd.fms;

public class PremiumFlight extends Flight {
    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return getPassengersList().add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return getPassengersList().remove(passenger);
        }
        return false;
    }
}
