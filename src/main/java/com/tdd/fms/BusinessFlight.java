package com.tdd.fms;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id){
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return getPassengersList().add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
