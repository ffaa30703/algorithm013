package com.keep.java.week3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelp(n, k,1, new LinkedList<>());
        return ans;
    }

    public void combineHelp(int n, int k, int first, LinkedList<Integer> list) {
        //terminate
        if (list.size() == k) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = first; i <= n; i++) {
            list.add(i);
            combineHelp(n, k, i + 1,list);
            list.removeLast();
        }

    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
