package main;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    List<Store> stores;

    public void addListOfStores(List<Store> stores)
    {
        this.stores = stores;
    }
    public List<Store> getListOfStores(Location loc)
    {
        List<Store> temp= new ArrayList<Store>();
        this.stores.forEach(store->
        {if(store.loc.pincode == loc.pincode)
            temp.add(store);
        });
        return temp;
    }

}
