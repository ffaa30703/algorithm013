package com.keep.java.week6;

public class MinPathSum {


    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }

        }
        return dp[n - 1][m - 1];


    }

    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i] = grid[0][i] + dp[i - 1];

        }
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);

//                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }

        }
        return dp[m - 1];


    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinPathSum().minPathSum(a));
        System.out.println(new MinPathSum().minPathSum1(a));
    }
}
