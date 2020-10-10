package com.keep.java.week9;

import java.util.Stack;

public class ReverseWords151 {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String ss : s1) {
            if (ss.trim().isEmpty()) continue;
            stack.push(ss);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop() + " ");
        }
        return builder.substring(0, builder.length() - 1);
    }

    public String reverseWords2(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        int n = cs.length;
        resever(cs, 0, n - 1);

        reverseWords(cs, n);
        return cleanSpace(cs, n);
    }

    String cleanSpace(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }
        return new String(a).substring(0, i);
    }


    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                i++;
            }
            while (j < i || j < n && a[j] != ' ') {
                j++;
            }
            resever(a, i, j - 1);
        }
    }


    void resever(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;

        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords151().reverseWords2("   ac   bd   "));
    }
}
