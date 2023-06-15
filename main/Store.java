package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store
{
    Location loc;
    VehicleManagerFactory vehicleManagerFactory;
    VehicleManager vehicleManager;
    VehicleType vehicleType;
    List<Reservation> reservationList;

    public Store(Location loc,List<Vehicle> vehiclesList) {
        this.loc = loc;
        this.vehicleManagerFactory = new VehicleManagerFactory();
        this.reservationList = new ArrayList<>();

        for(int i=0;i<vehiclesList.size();i++)
        {
            this.vehicleManager = this.vehicleManagerFactory.getVehicleManager(vehiclesList.get(i).vehicleType);
            //System.out.println(vehiclesList.get(i).vehicleType);
            this.vehicleManager.addVehicleToList(vehiclesList.get(i));
        }
    }

    List<Vehicle> getListOfVehicle(VehicleType vehicleType)
    {
        this.vehicleManager = this.vehicleManagerFactory.getVehicleManager(vehicleType);
        return this.vehicleManager.getListOfVehicle();
    }

    Reservation makeReservation(User user,Vehicle vehicle)
    {
        this.vehicleManager = this.vehicleManagerFactory.getVehicleManager(vehicle.vehicleType);
        if(this.vehicleManager.reserveVehicle(vehicle)==true)
        {
            Date current = new Date(System.currentTimeMillis());
            Date end = new Date(System.currentTimeMillis() + (1000 * 60 * 24 * 3));
            Reservation reservation= new Reservation(user,vehicle,current,end);
            this.reservationList.add(reservation);
            return reservation;
        }
        return null;
    }

    void completeReservation(Reservation reservation)
    {

        Vehicle vehicle = reservation.vehicle;
        this.vehicleManager = this.vehicleManagerFactory.getVehicleManager(vehicle.vehicleType);
        this.vehicleManager.freeVehicle(vehicle);
    }

}
