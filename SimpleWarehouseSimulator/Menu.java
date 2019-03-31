package com.Warehouse;

import java.util.List;

public class Menu {

    public static void main(String[] argv){

        Item item1 = new Item("Milk", 0.5, 10, ItemCondition.NEW);
        Item item2 = new Item("Sparkling water",1,25,ItemCondition.USED);
        Item item3 = new Item("Chair",50,1,ItemCondition.REFURBISHED);
        Item item4 = new Item("Flowers", 1.5, 10, ItemCondition.NEW);
        Item item5 = new Item("Painting", 2, 40, ItemCondition.REFURBISHED);
        Item item6 = new Item("Cookies", 3, 10, ItemCondition.NEW);

        System.out.println("Check method print() from Item class for "+item3.name);
        item3.print();

        //Build warehouses
        FulfillmentCenter warehouse1 = new FulfillmentCenter("Warehouse 1",1000);
        FulfillmentCenter warehouse2 = new FulfillmentCenter("Warehouse 2",500);
        FulfillmentCenter warehouse3 = new FulfillmentCenter("Warehouse 3",100);


        //---------------------------Methods from FullfillmentCenter------------------------------//

        //Add products to warehouses
        warehouse1.addProduct(item1);
        warehouse1.addProduct(item1);
        warehouse1.addProduct(item2);
        warehouse1.addProduct(item3);

        warehouse2.addProduct(item3);
        warehouse2.addProduct(item4);

        warehouse3.addProduct(item4);
        warehouse3.addProduct(item5);
        warehouse3.addProduct(item6);


        //Get product
        System.out.println("Before use method getProduct(), quantity of product is: "+item1.quantity);
        warehouse1.getProduct(item1);
        System.out.println("Check method getProduct(). Now quantity of product is:"+item1.quantity+"\n");

        //Remove product
        System.out.println("Method removeProduct() for: "+warehouse1.warehouseName+" and remove product "+item1.name+". Now list of product: ");
        warehouse1.removeProduct(item1);

        //Search product
        System.out.println("\nMethod search() in "+warehouse3.warehouseName+ " and we search product "+item5.name);
        warehouse3.search("Painting");


        //Partial search
        System.out.println("\nMethod searchPartial() for letters -ir for "+warehouse1.warehouseName);
        List<Item> part = warehouse1.searchPartial("ir");
        for (int i = 0; i<warehouse1.searchPartial("ir").size(); i++)
        {
            System.out.print("Find name: " + part.get(i).name+"\n");
        }


        //Count by condition
        System.out.println("\nSearching amount of products with condition NEW in "+warehouse3.warehouseName);
        warehouse3.countByCondition(ItemCondition.NEW);

        //Summary
        System.out.println("\nMethod summary()");
        warehouse1.summary();
        warehouse2.summary();
        warehouse3.summary();


        //Sort by name
        System.out.println("\nMethod sortByName for "+ warehouse3.warehouseName);
        warehouse3.sortByName();


        //Sort by amount
        System.out.println("\nMethod sortByAmount for "+ warehouse1.warehouseName);
        warehouse1.sortByAmount();

        //Max of product
        System.out.println("\nMethod max() from Collections for "+warehouse2.warehouseName);
        System.out.print("Product that is the most in warehouse is: "+warehouse2.max().name+"\n");



        //---------------------------Methods from FullfillmentCenterContainer--------------------//


        //Build Container for warehouses
        FulfillmentCenterContainer Container = new FulfillmentCenterContainer();

        //Add warehouses to container
        System.out.println("\nCheck method addCenter()");
        Container.addCenter("WarehouseFromMethod", 9000);
        Container.addCenter("SecondWarehouseFromMethod",100);
        Container.addCenter(warehouse1);
        Container.addCenter(warehouse3);

        //Remove warehouse from container
        System.out.println("\nCheck method removeCenter()");
        Container.removeCenter("SecondWarehouseFromMethod");


        //Find empty warehouses
        System.out.println("\nCheck method findEmpty()");
        List<FulfillmentCenter> empty = Container.findEmpty();
        System.out.print("\nEmpty warehouses: ");
        for (FulfillmentCenter fulfillmentCenter : empty)
        {
            System.out.println(fulfillmentCenter.warehouseName);
        }

       //Method summary()
        System.out.println("\nCheck method summary()");
        Container.summary();






    }
}
