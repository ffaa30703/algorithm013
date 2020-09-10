package com.keep.java.week6;

public class NumDecodings91 {

    public int numDecodings(String s) {

        if (s == null | s.isEmpty()) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[n];

    }
    int numDecodings2(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            int tmp = curr;
            if (cs[i] == '0')
                if (cs[i - 1] == '1' || cs[i - 1] == '2') curr = pre;
                else return 0;
            else if (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] >= '1' && cs[i] <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }


    public static void main(String[] args) {
        System.out.println(new NumDecodings91().numDecodings("226"));
    }
}
