package main;

import java.util.ArrayList;
import java.util.List;

public interface VehicleManager {
    List<Vehicle> list = new ArrayList<>();

    public List<Vehicle> getListOfVehicle();

    public boolean reserveVehicle(Vehicle vehicle);

    public boolean freeVehicle(Vehicle vehicle);

    public boolean deleteVehicle(Vehicle vehicle);

    public void addVehicleToList(Vehicle vehicle);
}
