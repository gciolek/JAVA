package com.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Solution {

    public int N;

    public Solution(int N) {
        this.N = N;
    }

    public void fillArray(List<Integer> array) throws Exception{
        if(N>1E5){
            throw new TooBigSize();
        }
        Random rand = new Random();
        for(int i =0; i<N;i++){
            int k = rand.nextInt(10);
            array.add(i,k);
        }
    }

    public int solution(List<Integer> array){
        int solution;
        Collections.sort(array);

        if(array.get(0)>=2) {
            solution = 1;
            System.out.println("The smallest number that is not in array is: " + solution);
        }

        for(int i=0;i<array.size()-1;i++){
            if(array.get(i+1)-array.get(i)>=2){
                solution = array.get(i)+1;
                System.out.println("The smallest number that is not in array is: "+solution);
                return solution;
            }
        }
        return 0;
    }

    public void print(List array){
        Iterator itr = array.iterator();
        while (itr.hasNext()) {
            Object elem = itr.next();
            System.out.print(elem+" ");
        }
    }
}
