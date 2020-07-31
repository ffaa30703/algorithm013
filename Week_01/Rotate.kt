package com.keep.algorithmic


/**
 * 旋转数组
 */

fun rotate(nums: IntArray, k: Int): Unit {

    var prev = 0
    var next = 0
    var start = 0
    var count = 0
    var current = 0

    while (count < nums.size) {
        current = start
        prev = nums[start]
        do {
            next = (current + k) % (nums.size)
            val temp = nums[next]
            nums[next] = prev
            prev = temp
            current = next
            count++
        } while (start != current)

        start++
    }

}

fun rotate2(nums: IntArray, k: Int): Unit {
    val kk = k % nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, kk - 1)
    reverse(nums, kk, nums.size - 1)
    println(nums.toList())

}

fun reverse(nums: IntArray, start: Int, end: Int) {
    var i = start
    var j = end
    var temp: Int
    while (i < j) {
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        i++
        j--
    }
}


fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
//    rotate(nums, 3)
    rotate2(nums, 3)
}