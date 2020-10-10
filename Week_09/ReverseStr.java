package com.keep.java.week9;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i = i + 2 * k) {
            int l = i, r = Math.min(i + k - 1, n - 1);
            while (l < r) {
                char temp = cs[l];
                cs[l] = cs[r];
                cs[r] = temp;
                l++;
                r--;
            }
        }
        return new String(cs);

    }

    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg", 2));
    }
}
