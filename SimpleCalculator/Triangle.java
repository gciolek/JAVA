package com.example.figure;

public class Triangle extends Figure implements Print{
    private double a,b,c;

    public Triangle(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
    }

    @Override double calculateArea() {

        if (a+b>c & b+c>a & c+a>b) {
            double area = (Math.sqrt((a+b+c)*(a+b-c)*(a-b+c)*(-a+b+c)))/4;
            return area;
        }
        else
        {
            System.out.println("You can't build a triangle from this parameters!");
            return 0;
        }

    }

    @Override double calculatePerimeter() {
        if (a+b>c & b+c>a & c+a>b) {
            double perimeter = a + b + c;
            return perimeter;
        }
        else
        {
            System.out.println("You can't build a triangle from this parameters!");
        }
        return 0;
    }

    @Override public void print() {
        System.out.print("Area of triangle is "+calculateArea()+" and perimeter is "+calculatePerimeter());
    }
}
