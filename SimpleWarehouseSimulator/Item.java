package com.Warehouse;


public class Item implements Comparable<Item>{
    public String name;
    public double mass;
    public int quantity;
    public ItemCondition state;

    public Item(String name, double mass, int quantity, ItemCondition state){
        this.name = name;
        this.mass = mass;
        this.quantity = quantity;
        this.state = state;

    }

    void print(){
        System.out.println("INFORMATION ABOUT PRODUCT: \nName - "+name+"\nMass - "+mass+"\nQuantity - "+quantity+"\nState - "+state+"\n");
    }

    //zwraca 0 gdy takie same
    @Override
    public int compareTo(Item it){
        return name.compareTo(it.name);
    }
}
