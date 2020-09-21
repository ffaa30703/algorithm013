package com.keep.java.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();

        int l = intervals[0][0], r = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] item = intervals[i];
            if (item[0] > r) {
                ans.add(new int[]{l, r});
                l = item[0];
                r = item[1];
            } else {
                r = Math.max(r, item[1]);
            }

        }
        ans.add(new int[]{l, r});
        int[][] arrs = new int[ans.size()][];
        ans.toArray(arrs);
        return arrs;
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{
//                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//        };
        int[][] intervals = new int[][]{
                {1, 4}, {0, 0}
        };
        int[][] merge = new Merge().merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
            ;
        }

    }
}
