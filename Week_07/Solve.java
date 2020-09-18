package com.keep.java.week7;

public class Solve {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        int n = board.length;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
//                board[0][j] = '#';
                dfs(0, j, board, n, m);
            }
            if (board[n - 1][j] == 'O') {
//                board[n - 1][j] = '#';
                dfs(n - 1, j, board, n, m);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O') {
//                board[i][0] = '#';
                dfs(i, 0, board, n, m);
            }
            if (board[i][m - 1] == 'O') {
//                board[i][m - 1] = '#';
                dfs(i, m - 1, board, n, m);
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }

            }
        }

    }

    void dfs(int i, int j, char[][] board, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        for (int k = 0; k < direction.length; k++) {
            dfs(i + direction[k][0], j + direction[k][1], board, n, m);
        }

    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//        };
        char[][] board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        Solve solve = new Solve();
        solve.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");

        }
    }
}
