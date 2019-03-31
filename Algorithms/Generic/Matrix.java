package com.Generic;


import java.util.*;

public class Matrix {

    Random generator = new Random();

    public void fillMatrix(List matrix){
          for(int rowNum = 0;rowNum<4;rowNum++){
            List<Integer> oneRow = new ArrayList<>();
            matrix.add(rowNum,oneRow);

            for(int columnNum = 0; columnNum<4;columnNum++){
                int war = generator.nextInt(10);
                oneRow.add(columnNum,war);
            }
        }

    }


    public void addMatrix(List<Integer> matrix1, List<Integer> matrix2, List endMatrix){
        for(int i=0;i<4;i++) {
            List<Integer> oneRow = new ArrayList<>();
            endMatrix.add(i, oneRow);

            for(int j=0;j<4;j++){
                int sum = matrix1.get(i)+matrix2.get(i);
                endMatrix.add(j,sum);
            }
        }

    }


    public void print(List matrix) {
        System.out.println("\n");
        Iterator itr = matrix.iterator();
        while (itr.hasNext()) {
            Object elem = itr.next();
            System.out.println(elem);
        }
    }

}




