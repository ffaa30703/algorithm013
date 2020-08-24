package com.keep.java.week4;

public class NumIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //clear
                    clear(grid, i, j);

                }
            }

        }
        return count;


    }

    void clear(char[][] grid, int i, int j) {
        //
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        clear(grid, i - 1, j);
        clear(grid, i, j + 1);
        clear(grid, i + 1, j);
        clear(grid, i, j - 1);


    }


    public static void main(String[] args) {
        char[][] i = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] i2 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumIslands().numIslands(i));
    }
}
