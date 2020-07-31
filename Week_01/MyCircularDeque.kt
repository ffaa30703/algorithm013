package com.keep.algorithmic.week1

import kotlinx.coroutines.internal.artificialFrame

class MyCircularDeque(k: Int) {

    private val data = arrayOfNulls<Int>(k)

    var head = 0
    var tail = 0
    var size = 0

    /** Initialize your data structure here. Set the size of the deque to be k. */


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (size == data.size) return false

        head = (head - 1 + data.size) % data.size
        data[head] = value
        size++
        return true

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (size == data.size) return false
        data[tail] = value
        tail = (tail + 1) % data.size
        size++
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (size == 0) return false
        data[head] = -1
        head = (head + 1) % data.size
        size--
        return true

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (size == 0) return false
        tail = (tail - 1 + data.size) % data.size
        data[tail] = -1
        size--
        return true

    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (size == 0) return -1
        return data[head]!!


    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (size == 0) return -1
        return data[(tail - 1 + data.size) % data.size]!!
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return size == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return size == data.size
    }

}

fun main() {
    var deque = MyCircularDeque(3)
    println(deque.insertLast(1))
    println(deque.insertLast(2))
    println(deque.insertFront(3))
    println(deque.insertFront(4))

    println(deque.getRear())
    println(deque.isFull())
    println(deque.deleteLast())
    println(deque.insertFront(4))
    println(deque.getFront())
}
