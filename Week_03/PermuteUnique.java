package com.keep.java.week3;

import java.util.*;

public class PermuteUnique {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, path, used);

        return ans;

    }

    private void dfs(int[] nums, Deque<Integer> path, boolean[] used) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && (used[i - 1] == false))
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, path, used);
            used[i] = false;
            path.removeLast();


        }
    }


    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{3, 3, 0, 3}));
    }
}
