package com.tdd.fms;

public class Passenger {
    private String bookingId;
    private String name;
    private boolean vip;
    private Integer bonusPoint;
    private Integer distanceTravelled;

    public Passenger(String bookingId, String name, boolean vip, Integer bonusPoint, Integer distanceTravelled) {
        this.bookingId = bookingId;
        this.name = name;
        this.vip = vip;
        this.bonusPoint = bonusPoint;
        this.distanceTravelled = distanceTravelled;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Integer bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public Integer getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(Integer distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int calculatePassengerBonusPoints(Passenger passenger) {
        if(passenger.isVip()){
            return passenger.getDistanceTravelled()/10;
        }else {
            return passenger.getDistanceTravelled()/20;
        }
    }

}
