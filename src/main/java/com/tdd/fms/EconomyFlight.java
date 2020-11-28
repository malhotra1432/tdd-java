package com.tdd.fms;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id){
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger){
        return getPassengersList().add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger){
        if(!passenger.isVip()){
            return getPassengersList().remove(passenger);
        }
        return false;
    }
}
