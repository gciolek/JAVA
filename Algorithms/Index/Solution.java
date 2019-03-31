package com.Index;

public class Solution {

    public int[] solution (float[] arr, float target) throws Exception {
        int[] res = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               if (arr[i] + arr[j] == target) {
                   res[0] = j;
                   res[1] = i;
               }

            }
        }
        if(res[0]==0 && res[1]==0)
            throw new Exception("Array don't have elements sum to target");
        else
            System.out.println("Index from array to give target: "+res[0]+" "+res[1]);
        return res;
    }
}
