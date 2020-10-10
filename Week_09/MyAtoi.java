package com.keep.java.week9;

import java.util.HashMap;
import java.util.Map;

public class MyAtoi {

    int myAtoi1(String str) {
        int length = str.length();
        int sign = 1, base = 0, i = 0;
        while (i < length && str.charAt(i) == ' ') {
            i++;
        }
        if (i == length ) return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = 1 - 2 * ((str.charAt(i++) == '-') ? 1 : 0);
        }
        while (i < length && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');

        }
        return base * sign;
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            automaton.get(str.charAt(i));

        }
        return (int) (automaton.sign * automaton.ans);

    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans,  -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c))
                return 2;
            return 3;
        }
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new MyAtoi().myAtoi1("   -42"));
        System.out.println(new MyAtoi().myAtoi("   -42"));
    }

}
