package com.keep.java.week4;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int top = 0;
        int bottom = matrix.length - 1;
        int v = matrix.length;
        int h = matrix[0].length;
        int vmid = 0;

        while (top <= bottom) {
            vmid = (top + bottom) / 2;
            int[] m = matrix[vmid];
            if (m.length == 0) {
                return false;
            }

            if (m[0] <= target && target <= m[m.length - 1]) {
                int left = 0;
                int right = m.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (m[mid] == target) return true;
                    if (target > m[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            if (target > m[m.length - 1]) {
                top = vmid + 1;
            } else {
                bottom = vmid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] i = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new SearchMatrix().searchMatrix(i, 13));
    }
}
