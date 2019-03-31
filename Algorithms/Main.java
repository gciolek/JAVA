package com;

import com.Generic.Matrix;
import com.Index.Solution;
import com.Sort.Time;
import com.com.Chain.Substring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Time now = new Time();
        now.fillArray();
        now.bubbleSort();
        now.selectionSort();
        now.shellSort();
        now.insertionSort();
        now.gnomeSort();

        Substring sub = new Substring();
        sub.substring("abcd","cdabcdab");

        Solution sol = new Solution();
        sol.solution(new float[]{1, 5, 2, 7, 15},9);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int N = scan.nextInt();

        List<Integer> array = new ArrayList<>();

        com.Method.Solution tmp = new com.Method.Solution(N);
        tmp.fillArray(array);
        tmp.print(array);
        tmp.solution(array);

        List<Integer> matrix1 = new ArrayList<>();
        List<Integer> matrix2 = new ArrayList<>();
        List<Integer> endMatrix = new ArrayList<>();

        Matrix mat = new Matrix();
        Matrix mat2 = new Matrix();
        Matrix end = new Matrix();
        mat.fillMatrix(matrix1);
        mat2.fillMatrix(matrix2);
        mat.print(matrix1);
        System.out.println(" ");
        mat2.print(matrix2);

        end.addMatrix(matrix1,matrix2,endMatrix);
        System.out.println(" ");
        end.print(endMatrix);



    }
}
