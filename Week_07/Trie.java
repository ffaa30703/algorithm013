package com.keep.java.week7;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }

        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }


}
