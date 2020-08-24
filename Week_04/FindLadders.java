package com.keep.java.week4;

import java.util.*;

public class FindLadders {

    Map<String, Integer> wordId = new HashMap<>();//word -> id
    ArrayList<String> idWord = new ArrayList<>();
    ArrayList<Integer>[] edges;

    public List<List<String>> findLaddersBfs(String beginWord, String endWord, List<String> wordList) {
        int id = 0;

        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }

        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int dest = wordId.get(endWord);
        List<List<String>> res = new ArrayList<>();
        int[] cost = new int[id];
        for (int i = 0; i < id; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index));
                }
                res.add(tmp);
            } else {
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        ArrayList<Integer> tmp=new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp);
                    }
                }
            }
        }
        return res;

    }

    private boolean transformCheck(String s, String s1) {
        int diff = 0;
        for (int i = 0; i < s.length() && diff < 2; i++) {
            if (s.charAt(i) != s1.charAt(i)) diff++;
        }
        return diff == 1;
    }


    List<List<String>> ans = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(beginWord, endWord, wordList, list);
        return ans;
    }

    void dfs(String beginWord, String endWord, List<String> wordList, List<String> visited) {
        if (beginWord.equals(endWord)) {
            if (ans.isEmpty()) {
                min = visited.size();
                ans.add(new ArrayList<>(visited));
                return;
            }
            List<String> list = ans.get(0);
            if (visited.size() == list.size()) {
                ans.add(new ArrayList<>(visited));
            } else if (visited.size() < list.size()) {
                ans.clear();
                min = visited.size();
                ans.add(new ArrayList<>(visited));
            }

            return;
        }
        //当前的长度到达了 min，还是没有到达结束单词就提前结束
        if (visited.size() >= min) {
            return;
        }


        char[] bchars = beginWord.toCharArray();
        for (int i = 0; i < wordList.size(); i++) {
            String ds = wordList.get(i);
            if (visited.contains(ds)) continue;
            char[] dschars = ds.toCharArray();
            int diff = 0;
            for (int j = 0; j < dschars.length; j++) {
                if (dschars[j] != bchars[j]) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) {
                visited.add(ds);
                dfs(ds, endWord, wordList, visited);
                visited.remove(ds);
            }


        }


    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(new FindLadders().findLaddersBfs(beginWord, endWord, wordList));
    }
}
