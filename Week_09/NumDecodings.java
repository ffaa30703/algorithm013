package com.keep.java.week9;

public class NumDecodings {
    public int numDecodings(String s) {
//        int n = s.length();
//        if (n == 0) return 0;
//        int[] dp = new int[n + 1];
//        dp[n] = 1;
//        dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
//        for (int i = n - 2; i >= 0; i--) {
//            if (s.charAt(i) == '0') continue;
//            else dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
//        }
//        return dp[0];
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;
        for (int i = 1; i < n; i++) {
            int tmp = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1') {
                    curr = curr + pre;
                } else if (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                    curr = curr + pre;
                }
            }
            pre=tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("2026"));
    }
}
