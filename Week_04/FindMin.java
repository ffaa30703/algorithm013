package com.keep.java.week4;

public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] >= nums[left])
            return nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new FindMin().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
