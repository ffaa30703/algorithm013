package com.keep.java.week7;

import javax.swing.plaf.IconUIResource;

public class FindCircleNum547 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }

            }
        }
        return unionFind.getCount();
    }

    public int findCircleNumdfs(int[][] M) {
        int n = M.length;
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(M, i, n, visited);
                count++;
            }
        }

        return count;
    }

    void dfs(int[][] M, int i, int n, int[] visited) {
        if (i >= n) return;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, j, n, visited);
            }

        }


    }


    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new FindCircleNum547().findCircleNum(m));
        System.out.println(new FindCircleNum547().findCircleNumdfs(m));
    }
}
