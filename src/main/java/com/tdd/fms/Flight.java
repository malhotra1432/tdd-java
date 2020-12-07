package com.tdd.fms;

import java.util.ArrayList;
import java.util.List;

public abstract class Flight {
   String id;
   List<Passenger> passengersList = new ArrayList<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Passenger> getPassengersList() {
        return passengersList;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
