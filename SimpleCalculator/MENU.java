package com.example.figure;

import java.util.Scanner;

public class MENU {

    public static int menu(){

        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     Choose figure: ");
        System.out.println("     1. Triangle ");
        System.out.println("     2. Square ");
        System.out.println("     3. Circle ");
        System.out.println("     0. Exit");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int choice = menu();

        while(choice!=0){
            switch(choice){
                case 1:

                    System.out.println("Enter 3 lengths of triangle");
                    System.out.print("a= ");
                    double a = in.nextDouble();
                    System.out.print("b= ");
                    double b = in.nextDouble();
                    System.out.print("c= ");
                    double c = in.nextDouble();
                    Triangle triangle = new Triangle(a,b,c);
                    triangle.print();

                    break;

                case 2:
                    System.out.println("Enter the length of the side of the square: ");
                    System.out.print("a= ");
                    double dl = in.nextDouble();
                    if(dl<=0)
                    {
                        System.out.println("Length is less than 0! Enter number bigger than 0.");
                    }
                    else {
                        Square square = new Square(dl);
                        square.print();
                    }
                    break;

                case 3:
                    System.out.println("Enter the length of the radius: ");
                    System.out.print("r= ");
                    double r = in.nextDouble();
                    if(r<=0)
                    {
                        System.out.println("Length is less than 0! Enter number bigger than 0.");
                    }
                    else {
                        Circle circle = new Circle(r);
                        circle.print();
                    }
                    break;

            }

            System.out.println("\nPress Enter, to continue...");

            choice = menu();
        }


        System.out.println("     ****************************************");
        System.out.println("\n     End of program\n\n");
    }
}

