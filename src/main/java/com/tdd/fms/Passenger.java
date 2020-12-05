package com.tdd.fms;

public class Passenger {
    private final String bookingId;
    private final String name;
    private final boolean vip;

    public Passenger(String bookingId, String name, boolean vip){
        this.bookingId = bookingId;
        this.name = name;
        this.vip = vip;
    }

    public String getBookingId() { return bookingId; }

    public String getName(){
        return name;
    }

    public boolean isVip(){
        return vip;
    }

}
