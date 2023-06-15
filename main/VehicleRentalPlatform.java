package main;

import java.util.List;

public class VehicleRentalPlatform
{
    List<User> users;
    StoreManager storeManager;

    public VehicleRentalPlatform(List<User> usersToAdd, List<Store> storesToAdd)
     {
         this.users = usersToAdd;
         this.storeManager = new StoreManager();
         this.storeManager.addListOfStores(storesToAdd);

     }

    List<Store> getListOfStores(User user, Location loc)
    {
        return this.storeManager.getListOfStores(loc);
    }
}
