package com.keep.java.week8;


import java.util.Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = (s + e) >> 1;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);

        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 5, 1};
        System.out.println(new ReversePairs().reversePairs(nums));

    }
}
