package com.keep.algorithmic.week2

import java.util.*

data class KeyVal(val first: Int) {
    var second: Int = 0
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val priorityQueue = PriorityQueue(nums.size, Comparator<KeyVal> { o1, o2 -> o2!!.second - o1!!.second })
    val map = mutableMapOf<Int, KeyVal>()
    for (n in nums) {
        if (!map.containsKey(n)) {
            map[n] = KeyVal(n)
        }
        map[n]!!.second += 1
    }
    map.values.toList().forEach {
        priorityQueue.add(it)
    }
    var list = mutableListOf<Int>()
    for (i in 0 until k) {
        list.add(priorityQueue.poll().first)
    }
    return list.toIntArray()

}


fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    println(topKFrequent(nums, 2).toList())
}