package com.example.figure;

public class Circle extends Figure implements Print{
    private double r;

    public Circle(double r){
        this.r=r;
        if(r<0)
            System.out.println("The length is less than 0");


    }

    @Override double calculateArea() {
        return Math.PI *r*r;
    }

    @Override double calculatePerimeter() {
        double perimeter = 2 * Math.PI *r;
        return perimeter;
    }

    @Override public void print() {
        System.out.print("Area of circle is "+calculateArea()+" and perimeter is "+calculatePerimeter());
    }
}
