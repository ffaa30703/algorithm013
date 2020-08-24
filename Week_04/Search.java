package com.keep.java.week4;

public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }


        return left == right && nums[left] == target ? left : -1;

    }


    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
