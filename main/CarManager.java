package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager implements VehicleManager{
    List<Vehicle> list;
    public CarManager()
    {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getListOfVehicle() {
        return this.list;
    }

    @Override
    public boolean reserveVehicle(Vehicle vehicle) {
        List<Vehicle> temp= this.list.stream().filter(l->(l.vehicleId==vehicle.vehicleId
                &&l.vehicleStatus==VehicleStatus.ACTIVE)).collect(Collectors.toList());
        if(temp.size()==0) return false;
        Vehicle tempVehicle = temp.get(0);
        tempVehicle.vehicleStatus = VehicleStatus.RESERVED;
        return true;
    }

    @Override
    public boolean freeVehicle(Vehicle vehicle) {
        List<Vehicle> temp= this.list.stream().filter(l->(l.vehicleId==vehicle.vehicleId
                &&l.vehicleStatus==VehicleStatus.RESERVED)).collect(Collectors.toList());

        if(temp==null) return false;
        Vehicle tempVehicle = temp.get(0);
        tempVehicle.vehicleStatus = VehicleStatus.ACTIVE;
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
