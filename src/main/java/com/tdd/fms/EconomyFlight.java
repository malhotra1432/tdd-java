package com.tdd.fms;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        var singlePassengerCount = getPassengersList().stream()
                .filter(passengerFilter -> passengerFilter.getBookingId().equals(passenger.getBookingId()))
                .count();
        if (singlePassengerCount == 0) {
            return getPassengersList().add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return getPassengersList().remove(passenger);
        }
        return false;
    }
}
