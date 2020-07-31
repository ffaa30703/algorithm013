package com.keep.java.week1;

public class MyCircularDeque {

    int[] data;
    int head = 0;
    int tail = 0;
    int size = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        data = new int[k];

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == data.length) return false;
        head = (head - 1 + data.length) % data.length;
        data[head] = value;
        size++;
        return true;


    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == data.length) return false;
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) return false;
        data[head] = -1;
        head = (head + 1) % data.length;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) return false;
        tail = (tail - 1 + data.length) % data.length;
        data[tail] = -1;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) return -1;
        return data[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) return -1;
        return data[(tail - 1 + data.length) % data.length];

    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == data.length;
    }
}
