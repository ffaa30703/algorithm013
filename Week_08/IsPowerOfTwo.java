package com.keep.java.week8;


public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(3));
    }
}
