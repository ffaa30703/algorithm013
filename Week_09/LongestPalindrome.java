package com.keep.java.week9;

public class LongestPalindrome {
    int left = 0, right = 0;

    public String longestPalindrome1(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            extendCenter(s, i, i);
            extendCenter(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    void extendCenter(String s, int i, int j) {
        int n = s.length();
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (right - left + 1 < j - 1 - (i + 1) + 1) {
            left = i + 1;
            right = j - 1;
        }

    }

    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;
        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }

            }

        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome1("babad"));
    }
}
