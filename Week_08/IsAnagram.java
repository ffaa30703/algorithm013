package com.keep.java.week8;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        int n = s.length();

        //一起做了
//        for (int i = 0; i < n; i++) {
//            count[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < n; i++) {
//            int index = t.charAt(i) - 'a';
//            count[index]--;
//            if (count[index] < 0) return false;
//        }
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new IsAnagram().isAnagram(s, t));
    }
}
