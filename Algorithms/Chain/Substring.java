package com.com.Chain;

public class Substring {

    public int substring(String a, String b){
        int counter = 1;
        if(b.equals(a))
        {
            System.out.println("Word b is same as a. Counter= "+counter);
        }
        else
        {
           while(a.contains(b)!=true) {
               a += a;
               counter++;
           }


        }
        System.out.println("\nCounter of a is:"+counter);
        return counter;
    }
}
