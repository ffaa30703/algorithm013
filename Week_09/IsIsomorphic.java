package com.keep.java.week9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (Integer i = 0; i < s1.length(); i++) {
            Integer i1 = m1.put(s1.charAt(i), i);
            Integer i2 = m2.put(s2.charAt(i), i);
            if (i1 != i2) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s1, String s2) {
        int[] s1C = new int[256];
        int[] s2C = new int[256];
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) ;
            int c2 = s2.charAt(i) ;
            if (s1C[c1] != s2C[c2]) return false;
            else {
                s1C[c1] = i+1;
                s2C[c2] = i+1;
                if (s1C[c1] != s2C[c2]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("ab", "aa"));
        System.out.println(new IsIsomorphic().isIsomorphic2("ab", "aa"));

    }
}
