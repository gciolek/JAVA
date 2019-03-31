package com.Warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class FulfillmentCenterContainer {

    public HashMap<String, FulfillmentCenter> fulfillmentCenterMap = new HashMap<>();

    //Dodaje nowy magazyn o podanej nazwie i zadanej pojemności do spisu magazynów
    public void addCenter(String warehouseName, double maxStorageCapacity){

        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter(warehouseName, maxStorageCapacity);
        fulfillmentCenterMap.put(warehouseName, fulfillmentCenter);

    }

    public void addCenter(FulfillmentCenter fulfillmentCenter)
    {
        fulfillmentCenterMap.put(fulfillmentCenter.warehouseName, fulfillmentCenter);
    }

    //Usuwa magazyn o podanej nazwie
    public void removeCenter(String warehouseName){

        fulfillmentCenterMap.remove(warehouseName);

    }

    //Zwraca listę pustych magazynów
    public List<FulfillmentCenter> findEmpty() {
        List<FulfillmentCenter> empty = new ArrayList<>();
        for(String key: fulfillmentCenterMap.keySet())  //keySet()-zbiór kluczy
        {
            FulfillmentCenter value = fulfillmentCenterMap.get(key); //zwraca wartość przypisaną do klucza
            if(value.productList.size() == 0)
            {
                empty.add(value);
            }
            System.out.println("" + key + " have: " + value.productList.size()+" products");
        }
        return empty;

    }

    //Wypisuje na wyjście informacje zawierające: nazwę magazynu i procentowe zapełnienie
    public void summary(){
        for(String key: fulfillmentCenterMap.keySet())
        {
            FulfillmentCenter value = fulfillmentCenterMap.get(key);
            System.out.print("\n" + key + " fill in : "+ ((value.currentMass/value.maxStorageCapacity)*100.0)+"%");
        }


    }


}
