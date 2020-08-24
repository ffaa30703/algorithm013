package com.keep.java.week4;

public class CanJump {
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1)
                    return true;
            }

        }
        return false;
    }

    //会超时
    boolean dfs(int[] nums, int index) {
        if (index >= (nums.length - 1)) return index == (nums.length - 1);

        int n = nums[index];
        for (int i = n; i > 0; i--) {
            if (dfs(nums, index + i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
