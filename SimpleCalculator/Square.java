package com.example.figure;

public class Square extends Figure implements Print{
    private double a;

    public Square(double a){
        this.a=a;
    }

    @Override double calculateArea() {
        double area = a*a;
        return area;
    }

    @Override double calculatePerimeter() {
        double perimeter = 4*a;
        return perimeter;
    }

    @Override public void print() {
        System.out.print("Area of square is "+calculateArea()+" and perimeter is "+calculatePerimeter());
    }

}
