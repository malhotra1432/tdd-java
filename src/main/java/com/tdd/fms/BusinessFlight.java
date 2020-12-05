package com.tdd.fms;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        var singlePassengerCount = getPassengersList().stream().filter(passengerFilter -> passengerFilter.getName().equals(passenger.getName())).count();
        if (singlePassengerCount == 0) {
            return getPassengersList().add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
