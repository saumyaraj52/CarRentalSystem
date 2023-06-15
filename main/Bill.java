package main;

public class Bill {
    Reservation reservation;
    BillStatus billStatus;

    public Bill(Reservation reservation)
    {
        this.reservation = reservation;
        this.billStatus = BillStatus.NOTPAID;
    }

    public long findBalanceAmount()
    {
        int chargePerHour = reservation.vehicle.chargePerHour;
        long diffInTime = ((reservation.reservationEnd.getTime()-reservation.reservationStart.getTime())/(1000*60));
        long totalBill = chargePerHour*diffInTime;
        return totalBill;
    }
}
