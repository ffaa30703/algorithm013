package com.keep.java.week7;

import java.util.HashMap;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int n = board[i][j];
                if (n == '.')
                    continue;
                int boxIndex = (i / 3) * 3 + j / 3;
                row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                col[j].put(n, col[j].getOrDefault(n, 0) + 1);
                box[boxIndex].put(n, box[boxIndex].getOrDefault(n, 0) + 1);

                if (row[i].get(n) > 1 || col[j].get(n) > 1 || box[boxIndex].get(n) > 1)
                    return false;


            }

        }
        return true;

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(new IsValidSudoku().isValidSudoku(board));
    }
}
