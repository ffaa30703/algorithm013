package com.keep.java.list;


import org.jetbrains.annotations.NotNull;

import java.util.*;


public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);

    }

}
