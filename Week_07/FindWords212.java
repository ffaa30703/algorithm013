package com.keep.java.week7;

import java.util.*;

public class FindWords212 {
    Trie trie = new Trie();
    int n, m;
    Set<String> ansList = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0 || words == null || words.length == 0) return new ArrayList<>(ansList);

        //将word 插入trie树

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        //遍历board 进行递归
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, board, "");

            }
        }


        return new ArrayList<>(ansList);


    }

    private void dfs(int i, int j, char[][] board, String s) {

        TrieNode node = trie.searchPrefix(s);
        if (node == null) {
            return;
        } else {
            if (node.isEnd()) {
                ansList.add(s);
            }
        }
        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        if (board[i][j] == '#')
            return;
        char temp = board[i][j];
        board[i][j] = '#';
        s += temp;


        dfs(i + 1, j, board, s);
        dfs(i, j + 1, board, s);
        dfs(i - 1, j, board, s);
        dfs(i, j - 1, board, s);

        board[i][j] = temp;


    }
    /*

    [["a","b"],["a","a"]]
["aba","baa","bab","aaab","aaa","aaaa","aaba"]
     */

    public static void main(String[] args) {
//        String[] words = new String[]{"oath", "pea", "eat", "rain"};

//        char[][] board = new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}

//
//        };/
        String[] words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board = new char[][]{
                {'a','b'},
                {'a','a'},
        };
        System.out.println(new FindWords212().findWords(board, words));
    }
}
