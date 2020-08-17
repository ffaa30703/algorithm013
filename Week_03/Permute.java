package com.keep.java.week3;


import java.util.*;

public class Permute {


    /**
     * 改善过后
     *
     * @param nums
     * @return
     */

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[len];//保留已经使用过的值，以空间换时间
        dfs(nums, used, path);


        return ans;
    }

    private void dfs(int[] nums, boolean[] used, Deque<Integer> path) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, used, path);

            //清除
            used[i] = false;
            path.pollLast();

        }

    }

    /**
     * 不使用used不存状态
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            output.add(nums[i]);
        }
        backTrack(len, output, 0);
        return ans;

    }

    private void backTrack(int len, ArrayList<Integer> output, int first) {
        if (first == len) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < len; i++) {
            Collections.swap(output, first, i);
            backTrack(len, output, first + 1);
            Collections.swap(output, first, i);

        }

    }


    public List<List<Integer>> permute3(int[] nums) {

        permuteHelp(nums, new LinkedHashSet<>());
        return ans;
    }


    void permuteHelp(int[] nums, LinkedHashSet<Integer> list) {
        //terminate
        if (list.size() == nums.length) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            permuteHelp(nums, list);
            list.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Permute().permute(nums));
        System.out.println(new Permute().permute2(nums));
        System.out.println(new Permute().permute3(nums));
    }
}
