package com.keep.java.week7;

public class NumIslands {
    public int numIslands(char[][] grid) {
        return numIslandsUnion(grid);
    }


    public int numIslandsUnion(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        IsLandUnion isLandUnion = new IsLandUnion(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < n && grid[i + 1][j] == '1') {
                        isLandUnion.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j + 1 < m && grid[i][j + 1] == '1') {
                        isLandUnion.union(i * m + j, i * m + j + 1);
                    }
                }

            }
        }
        return isLandUnion.count;
    }


    class IsLandUnion {
        int count = 0;
        int[] parent;

        public IsLandUnion(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            parent = new int[n * m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * m + j] = i * m + j;
                        count++;
                    } else {
                        parent[i * m + j] = 0;
                    }
                }
            }
        }

        public void union(int q, int p) {
            int rootq = find(q);
            int rootp = find(p);
            if (rootp == rootq) return;
            parent[rootp] = rootq;
            count--;
        }

        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }


    /**
     * dfs
     */
    int[][] direction = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslandsDfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    cleardfs(grid, i, j);
                    count++;

                }

            }
        }
        return count;
    }

    void cleardfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int[] d = direction[k];
            cleardfs(grid, i + d[0], j + d[1]);

        }

    }

    public static void main(String[] args) {

//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] grid = new char[][]{
                {'1'}, {'1'}
        };
        System.out.println(new NumIslands().numIslands(grid));
    }
}
