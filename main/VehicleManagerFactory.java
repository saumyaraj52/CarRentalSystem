package main;

public class VehicleManagerFactory {

    CarManager carManager;
    BikeManager bikeManager;

    public VehicleManagerFactory()
    {
        this.bikeManager = new BikeManager();
        this.carManager = new CarManager();
    }

    public VehicleManager getVehicleManager(VehicleType vehicleType) {
        if(vehicleType == VehicleType.CAR)
            return this.carManager;
        else return this.bikeManager;
    }
}
