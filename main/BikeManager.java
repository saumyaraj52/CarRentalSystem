package main;

import java.util.ArrayList;
import java.util.List;

public class BikeManager implements VehicleManager{
    List<Vehicle> list;

    public BikeManager()
    {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getListOfVehicle() {
        return this.list;
    }

    @Override
    public boolean reserveVehicle(Vehicle vehicle) {
        Vehicle temp= (Vehicle) this.list.stream().filter(l->(l.vehicleId==vehicle.vehicleId
                &&l.vehicleStatus==VehicleStatus.ACTIVE));

        if(temp==null) return false;
        temp.vehicleStatus = VehicleStatus.RESERVED;
        return true;
    }

    @Override
    public boolean freeVehicle(Vehicle vehicle) {
        Vehicle temp= (Vehicle) this.list.stream().filter(l->(l.vehicleId==vehicle.vehicleId
                &&l.vehicleStatus==VehicleStatus.RESERVED));

        if(temp==null) return false;
        temp.vehicleStatus = VehicleStatus.ACTIVE;
        return true;
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle) {
        Vehicle temp= (Vehicle) this.list.stream().filter(l->(l.vehicleId==vehicle.vehicleId));
        //this.list.remove(vehicle);

        if(temp==null) return false;
        temp.vehicleStatus = VehicleStatus.NOT_ACTIVE;
        return true;
    }

    @Override
    public void addVehicleToList(Vehicle vehicle) {
        this.list.add(vehicle);
    }
}
