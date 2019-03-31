package com.Warehouse;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FulfillmentCenter{
    List<Item> productList = new ArrayList<>();
    public String warehouseName;
    public double maxStorageCapacity;
    public double currentMass = 0;


    public FulfillmentCenter(String warehouseName, double maxStorageCapacity){
        this.warehouseName = warehouseName;
        this.maxStorageCapacity = maxStorageCapacity;

    }


    //Dodaje produkt
    public void addProduct(Item item){
        if(compareName(item)==0)
        {
            item.quantity+=item.quantity;
        }
        if(currentMass+item.mass < maxStorageCapacity)
        {
            productList.add(item);
            currentMass+=item.mass;
        }
        else
            System.err.println("Capacity of the warehouse is more than expected! You can't add product.");

    }

    // Zmniejsza ilość danego produktu o jeden lub usuwa go całkowicie, jeśli po zmianie wartość będzie równa 0.
    public void getProduct(Item item){

        if(productList.contains(item))
        {
            item.quantity--;
            if(item.quantity==0)
            {
                productList.remove(item);
            }
        }

    }

    //Usuwa dany produkt całkowicie z magazynu.
    public void removeProduct(Item item) {
        for(int i=0;i<productList.size();i++)
        {
            if(compareName(item)==0)
            {
                productList.remove(item);
            }
        }


        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).name);
        }

    }
    //Przyjmuje nazwę produktu i zwraca go. Zastosuj Comparator
    public Item search(String name){

        Iterator<Item> iterator = productList.iterator();
        while (iterator.hasNext())
        {
            Item product = iterator.next();
            if(compare(name, product.name) == 0)
            {
                System.out.println("You found me! "+product.name);
                return product;
            }
        }
        return null;
    }

    //Przyjmuje fragment nazwy produktu i zwraca wszystkie produkty, które pasują.
    public List<Item> searchPartial(String partialName){

        Iterator<Item> iterator = productList.iterator();
        List<Item> matchedProduct = new ArrayList<>();
        while (iterator.hasNext())
        {
            Item present = iterator.next();
            if (present.name.contains(partialName))
            {
                matchedProduct.add(present);
            }
        }
        return matchedProduct;
    }

    //Zwraca ilość produktów o danym stanie
    public int countByCondition(ItemCondition itemCondition){
        int counter=0;
        for(Item k : productList)
        {

            if (k.state==itemCondition) {
                counter++;
            }

        }
        System.out.println("Counter is: " + counter);
        return 0;
    }

    //Wypisuje na standardowe wyjście informację o wszystkich produktach
    public void summary(){
        for(Item item : productList)
        {
            System.out.println("\nName of product: " + item.name + "\nWarehouse: " + warehouseName);
            System.out.println("Mass of product: " + item.mass);
            System.out.println("Quantity of product: " + item.quantity);
            System.out.println("State of product: " + item.state);

        }
    }

    //Zwraca posortowana listę produktów – po nazwie alfabetycznie
    public List<Item> sortByName(){
        Collections.sort(productList);
        for(int i=0;i<productList.size();i++)
        {
            System.out.println(productList.get(i).name);
        }
        return productList;

    }

    //Zwraca posortowaną listę produktów po ilości – malejąco – własny Comparator
    public List<Item> sortByAmount(){
        Collections.sort(productList, new MyComparator().reversed());
        for(int i=0;i<productList.size();i++)
        {
            System.out.println(productList.get(i).quantity);
        }
        return productList;

    }

    //Zwraca produkt którego jest najwięcej z wykorzystaniem Collections.max();
    public Item max()
    {
        return Collections.max(productList, new MyComparator());
    }


    public int compareName(Item product)        //used in: addProduct, removeProduct
    {
        int result = 1;
        Iterator<Item> iterator = productList.iterator();
        while (result != 0 && iterator.hasNext())
        {
            result = product.name.compareTo(iterator.next().name);
        }
        return result;
    }


    public int compare(String name1, String name2)  //used in: search()
    {
        int result = 1;
        if (name1.equals(name2))
        {
            result = 0;
        }
        return result;
    }

}
