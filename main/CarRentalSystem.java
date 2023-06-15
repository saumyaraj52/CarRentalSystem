package main;

import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    public static void main(String[] args)
    {
        List<User> userList = new ArrayList<>();
        List<Store> storeList = new ArrayList<>();
        List<Vehicle> vehicleList = new ArrayList<>();
        List<Vehicle> vehicleList1 = new ArrayList<>();
        User user1 = new User("Saumya","abc");
        User user2 = new User("Rajat","abc");
        userList.add(user1);
        userList.add(user2);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle1.vehicleType = VehicleType.CAR;
        vehicle1.chargePerHour = 10;

        Vehicle vehicle2 = new Vehicle();
        vehicle2.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle2.vehicleType = VehicleType.CAR;
        vehicle2.chargePerHour = 11;

        Vehicle vehicle3 = new Vehicle();
        vehicle3.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle3.vehicleType = VehicleType.CAR;
        vehicle3.chargePerHour = 12;

        Vehicle vehicle4 = new Vehicle();
        vehicle4.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle4.vehicleType = VehicleType.CAR;
        vehicle4.chargePerHour = 13;

        Vehicle vehicle5 = new Vehicle();
        vehicle5.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle5.vehicleType = VehicleType.CAR;
        vehicle5.chargePerHour = 14;

        Vehicle vehicle6 = new Vehicle();
        vehicle6.vehicleStatus = VehicleStatus.ACTIVE;
        vehicle6.vehicleType = VehicleType.CAR;
        vehicle6.chargePerHour = 15;
        vehicleList1.add(vehicle4);
        vehicleList1.add(vehicle5);
        vehicleList1.add(vehicle6);
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);
        vehicleList.add(vehicle3);
        Location loc1 = new Location(1234,"Hyderabad");
        Location loc2 = new Location(5678,"Bangalore");
        System.out.println("Adding Stores now");
        Store store1 = new Store(loc1,vehicleList);
        Store store2 = new Store(loc2,vehicleList1);
        storeList.add(store1);
        storeList.add(store2);
        System.out.println("Stores added now");




        VehicleRentalPlatform vehicleRentalPlatform = new VehicleRentalPlatform(userList,storeList);
        List<Store> nearByStores = vehicleRentalPlatform.getListOfStores(user1,loc2);

        Store requiredStore = nearByStores.get(0);

        List<Vehicle> requiredStoreListOfVehicles = requiredStore.getListOfVehicle(VehicleType.CAR);
        Vehicle requiredVehicle = requiredStoreListOfVehicles.get(1);

        Reservation reservationRequired = requiredStore.makeReservation(user1,requiredVehicle);
        Bill requiredBill = new Bill(reservationRequired);
        long balanceAmount = requiredBill.findBalanceAmount();
        System.out.println("Balance Amount : "+balanceAmount);

        Payment requiredPayment = new Payment(requiredBill);
        requiredPayment.payBill();
        System.out.println("Payment Status : "+requiredPayment.paymentStatus);
        System.out.println("Bill Status : "+requiredPayment.bill.billStatus);

        if(requiredBill.billStatus == BillStatus.PAID)
        {
            requiredStore.completeReservation(reservationRequired);
        }
        System.out.println("Vehicles in requiredStore  : "+requiredStore.getListOfVehicle(requiredVehicle.vehicleType).size());

    }

}
