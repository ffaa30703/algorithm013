package com.keep.java.week9;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * dp
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) return 0;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;

    }

    /**
     * stack
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesStack(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;


    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
