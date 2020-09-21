package com.keep.java.week8;

import java.util.Arrays;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[10001];
        //记录arr1
        for (int i : arr1) {
            temp[i] += 1;
        }
        int index = 0;
        for (int n : arr2) {
            int c = temp[n];
            for (int i = 0; i < c; i++) {
                arr1[index++] = n;
                temp[n]--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            int c = temp[i];
            for (int j = 0; j < c; j++) {
                arr1[index++] = i;
                temp[i]--;
            }

        }
        return arr1;

    }

    /**
     * [2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
     * [2,42,38,0,43,21]
     * @param args
     */

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = new int[]{2,42,38,0,43,21};
        int[] ints = new RelativeSortArray().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));

    }
}
