package com.keep.java.week9;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l< r) {
            if (s.charAt(l) != s.charAt(r)) {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r -1);
            }
            l++;
            r--;


        }
        return true;
    }

    boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("abca"));
    }
}
