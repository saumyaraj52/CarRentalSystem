package main;

import java.util.Date;

public class Reservation {
    static int reservatinId;
    User user;
    Vehicle vehicle;

    Date reservationStart;
    Date reservationEnd;

    public Reservation(User user,Vehicle vehicle,Date strt,Date end)
    {
        this.reservatinId++;
        this.user = user;
        this.vehicle = vehicle;
        this.reservationStart = strt;
        this.reservationEnd = end;
    }
}
