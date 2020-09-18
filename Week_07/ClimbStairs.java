package com.keep.java.week7;

import java.util.HashMap;

public class ClimbStairs {
    /**
     * f(n)=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    HashMap<Integer, Integer> rst = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 1) return 1;
//直接进行傻递归
//        return climbStairs(n - 1) + climbStairs(n - 2);
        Integer a = rst.get(n);
        if (a != null) return a;
        int f = climbStairs(n - 1) + climbStairs(n - 2);
        rst.put(n, f);
        return f;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(3));
    }

}
