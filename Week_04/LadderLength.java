package com.keep.java.week4;

import java.util.*;

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Deque<String> deque = new ArrayDeque();
        deque.addLast(beginWord);
        HashSet visited = new HashSet();
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                String s = deque.pollFirst();
                if (s.equals(endWord)) {
                    return count+1;
                }
                char[] schars = s.toCharArray();
                for (int i = 0; i < wordList.size(); i++) {
                    String bs = wordList.get(i);
                    if (visited.contains(bs)) continue;
                    int diff = 0;
                    char[] bchars = bs.toCharArray();
                    for (int j = 0; j < bchars.length; j++) {
                        if (schars[j] != bchars[j]) diff++;
                        if (diff > 1) break;

                    }
                    if (diff == 1) {
                        visited.add(bs);
                        deque.addLast(bs);
                    }

                }


                size--;
            }
            count++;

        }

        return 0;


    }

    public static void main(String[] args) {
        List list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new LadderLength().ladderLength("hit", "cog", list));
    }
}
