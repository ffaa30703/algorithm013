package com.keep.java.week4;

public class Jump45 {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }


        }

        return step;

    }

    public static void main(String[] args) {
        System.out.println(new Jump45().jump(new int[]{2, 3, 1, 1, 4}));
    }

}
