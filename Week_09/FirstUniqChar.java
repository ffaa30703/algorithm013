package com.keep.java.week9;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
