package com.keep.java.week7;

import java.util.*;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> col = new HashSet();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        dfs(ans, queue, n, 0, col, diagonals1, diagonals2);
        return ans;
    }

    void dfs(List<List<String>> ans, int[] queue, int n, int row, Set<Integer> col, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generate(queue, n);
            ans.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (col.contains(i))
                    continue;

                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1))
                    continue;

                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2))
                    continue;

                queue[row] = i;
                col.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                dfs(ans, queue, n, row + 1, col, diagonals1, diagonals2);
                queue[row] = -1;
                col.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

    }

    private List<String> generate(int[] queue, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rows = new char[n];
            Arrays.fill(rows, '.');
            rows[queue[i]] = 'Q';
            board.add(new String(rows));

        }
        return board;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
