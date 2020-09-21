package com.keep.java.week8;

public class TotalNQueens {
    int size;
    int count;

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;

    }

    private void solve(int row, int rd, int ld) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | rd | ld));
        while (pos != 0) {
            int p = pos & (-pos);
            solve(row | p, (rd | p) << 1, (ld | p) >> 1);
            pos -= p;
        }
    }


    public static void main(String[] args) {
        System.out.println(new TotalNQueens().totalNQueens(4));
        System.out.println(Integer.toBinaryString(-5));
    }
}
