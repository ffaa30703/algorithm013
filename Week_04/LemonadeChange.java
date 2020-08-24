package com.keep.java.week4;

public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else {
                    if (five < 3) return false;
                    five -= 3;

                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{10, 10}));
    }
}
